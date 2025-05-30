package com.auction.ejb;

import com.auction.ejb.entity.Bid;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import jakarta.jms.*;
import java.util.List;

@Stateful
public class BidManagerBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/bidTopic")
    private Topic bidTopic;

    @EJB
    private BidStorageBean bidStorage;

    @EJB
    private AuctionManagerBean auctionManager;

    public void placeBid(Bid bid) {
        // Validate if auction is active
        if (!auctionManager.isAuctionActive(bid.getItemId())) {
            System.out.println("❌ Auction not active for item: " + bid.getItemId());
            return;
        }

        // Validate if bid amount is higher
        List<Bid> existingBids = bidStorage.getBids(bid.getItemId());
        double maxAmount = existingBids.stream()
                .mapToDouble(Bid::getAmount)
                .max()
                .orElse(0.0);

        if (bid.getAmount() <= maxAmount) {
            System.out.println("❌ Invalid bid. Must be higher than current max: $" + maxAmount);
            return;
        }

        // Passed: Store bid and notify
        bidStorage.addBid(bid);
        context.createProducer().send(bidTopic, bid.toString());
        System.out.println("✅ Bid placed: " + bid);
    }
}

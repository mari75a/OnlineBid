package com.auction.ejb;

import com.auction.ejb.entity.Bid;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import jakarta.jms.*;

@Stateful
public class BidManagerBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/bidTopic")
    private Topic bidTopic;

    @EJB
    private BidStorageBean bidStorage;

    public void placeBid(Bid bid) {
        // Bid validation logic here
        bidStorage.addBid(bid);
        context.createProducer().send(bidTopic, bid.toString());
        System.out.println("📥 Bid stored and sent: " + bid);
    }
}


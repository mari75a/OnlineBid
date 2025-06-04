package com.auction.ejb;

import jakarta.ejb.Stateless;

import java.util.HashMap;
import java.util.Map;

@Stateless
public class AuctionManagerBean {

    private static final Map<String, Boolean> auctionStatus = new HashMap<>();

    public void startAuction(String itemId) {
        auctionStatus.put(itemId, true);
        System.out.println(" Auction started for: " + itemId);
    }

    public void endAuction(String itemId) {
        auctionStatus.put(itemId, false);
        System.out.println(" Auction ended for: " + itemId);
    }

    public boolean isAuctionActive(String itemId) {
        return auctionStatus.getOrDefault(itemId, false);
    }
}

package com.auction.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class AuctionManagerBean {
    public void startAuction(String itemId) {
        System.out.println("Auction started for item: " + itemId);
    }

    public void endAuction(String itemId) {
        System.out.println("Auction ended for item: " + itemId);
    }
}

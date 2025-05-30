package com.auction.ejb;

import com.auction.ejb.entity.Bid;
import jakarta.ejb.Singleton;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class BidStorageBean {

    // Stores itemId → list of bids
    private final Map<String, List<Bid>> bidMap = new ConcurrentHashMap<>();

    public void addBid(Bid bid) {
        bidMap.computeIfAbsent(bid.getItemId(), k -> new ArrayList<>()).add(bid);
    }

    public List<Bid> getBids(String itemId) {
        return bidMap.getOrDefault(itemId, Collections.emptyList());
    }

    public Map<String, List<Bid>> getAllBids() {
        return bidMap;
    }
}

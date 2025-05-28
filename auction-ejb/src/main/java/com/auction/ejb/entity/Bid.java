package com.auction.ejb.entity;

import java.io.Serializable;

public class Bid implements Serializable {
    private String user;
    private String itemId;
    private double amount;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bid from " + user + " for item " + itemId + ": $" + amount;
    }
}

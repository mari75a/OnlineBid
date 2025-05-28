package com.auction.ejb;

import com.auction.ejb.entity.Bid;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import jakarta.jms.*;

@Stateful
public class BidManagerBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/bidTopic")
    private Topic bidTopic;

    public void placeBid(Bid bid) {
        // Add your bid validation logic here
        System.out.println("Bid placed: " + bid);
        context.createProducer().send(bidTopic, bid.toString());
    }
}

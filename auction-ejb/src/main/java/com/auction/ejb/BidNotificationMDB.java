package com.auction.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/bidTopic")
})
public class BidNotificationMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String bidMessage = message.getBody(String.class);
            System.out.println("Bid update received: " + bidMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

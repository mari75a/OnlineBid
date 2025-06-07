package com.auction.web;

import com.auction.ejb.BidManagerBean;
import com.auction.ejb.entity.Bid;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/placeBid")
public class BidServlet extends HttpServlet {

    @EJB
    private BidManagerBean bidManager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String user = request.getParameter("user");
            String itemId = request.getParameter("itemId");
            double amount = Double.parseDouble(request.getParameter("amount"));

            Bid bid = new Bid();
            bid.setUser(user);
            bid.setItemId(itemId);
            bid.setAmount(amount);

            boolean success = bidManager.placeBid(bid);
            if (success) {
                out.println("Bid placed successfully!");
            } else {
                out.println(" Bid was rejected. Check the bid amount or auction status.");
            }

        } catch (NumberFormatException e) {
            out.println(" Invalid bid amount. Please enter a valid number.");
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println(" An unexpected error occurred.");
        }
    }
}

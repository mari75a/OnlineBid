package com.auction.web;

import com.auction.ejb.BidManagerBean;
import com.auction.ejb.entity.Bid;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/placeBid")
public class BidServlet extends HttpServlet {

    @EJB
    private BidManagerBean bidManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Bid bid = new Bid();
        bid.setUser(request.getParameter("user"));
        bid.setItemId(request.getParameter("itemId"));
        bid.setAmount(Double.parseDouble(request.getParameter("amount")));
        System.out.println("hi");
        bidManager.placeBid(bid);

        response.getWriter().println("Bid placed successfully!");
    }
}

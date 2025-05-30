package com.auction.web;

import com.auction.ejb.BidStorageBean;
import com.auction.ejb.entity.Bid;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/leaderboard")
public class LeaderboardServlet extends HttpServlet {

    @EJB
    private BidStorageBean bidStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String itemId = req.getParameter("itemId");
        List<Bid> bids = bidStorage.getBids(itemId);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<table class='table table-striped'><thead><tr><th>User</th><th>Amount ($)</th></tr></thead><tbody>");
        for (Bid bid : bids) {
            out.println("<tr><td>" + bid.getUser() + "</td><td>" + bid.getAmount() + "</td></tr>");
        }
        out.println("</tbody></table>");
    }
}

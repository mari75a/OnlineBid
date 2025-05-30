package com.auction.web;

import com.auction.ejb.AuctionManagerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/auction")
public class AuctionServlet extends HttpServlet {

    @EJB
    private AuctionManagerBean auctionManager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        String itemId = request.getParameter("itemId");

        if (action != null && itemId != null) {
            if (action.equals("start")) {
                auctionManager.startAuction(itemId);
                response.getWriter().println("✅ Auction started for item: " + itemId);
            } else if (action.equals("end")) {
                auctionManager.endAuction(itemId);
                response.getWriter().println("✅ Auction ended for item: " + itemId);
            } else {
                response.getWriter().println("⚠️ Unknown action: " + action);
            }
        } else {
            response.getWriter().println("❌ Missing parameters.");
        }
    }
}

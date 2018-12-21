package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/profile_search")
public class MyAdsSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("mySearchTerm", req.getParameter("search"));
        String searchTerm = (String) req.getSession().getAttribute("mySearchTerm");
        User user = (User)req.getSession().getAttribute("user");

        req.setAttribute("userAds", DaoFactory.getAdsDao().search(searchTerm));
        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
    }
}

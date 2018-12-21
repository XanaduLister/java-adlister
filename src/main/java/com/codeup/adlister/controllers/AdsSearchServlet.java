package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class AdsSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("searchTerm", req.getParameter("search"));
        String searchTerm = (String) req.getSession().getAttribute("searchTerm");

        req.setAttribute("ads", DaoFactory.getAdsDao().search(searchTerm));
        req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req, resp);

    }
}

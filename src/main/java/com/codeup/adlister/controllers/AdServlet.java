package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdServlet", urlPatterns = "/ads/ad")
public class AdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adId = request.getParameter("adId");
		Ad ad = DaoFactory.getAdsDao().getAdByID(adId);
		String userId = Long.toString(ad.getUserId());
		User user = DaoFactory.getUsersDao().findUserById(userId);

		request.setAttribute("user", user);
		request.setAttribute("ad", ad);
		request.getRequestDispatcher("/WEB-INF/ads/ad.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

}

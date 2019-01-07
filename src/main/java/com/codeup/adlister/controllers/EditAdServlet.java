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

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/login");
			return;
		}
		String updateAd = request.getParameter("editAd");
		request.setAttribute("ad", DaoFactory.getAdsDao().getAdByID(updateAd));
		request.setAttribute("editAd", updateAd);
		request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		if (request.getParameter("category") == null) {
			request.setAttribute("error", "Please re-select a category.");

			// Setting session attributes so edit ad form is still pre-filled if error occurs
			request.getSession().setAttribute("title", title);
			request.getSession().setAttribute("description", description);
			request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);

		} else {
		User user = (User) request.getSession().getAttribute("user");
		long adId = Long.parseLong(request.getParameter("editAd"));

		Ad ad = new Ad(
				adId,
				user.getId(),
				request.getParameter("title"),
				request.getParameter("description"),
				request.getParameter("category")
		);
		DaoFactory.getAdsDao().update(ad);
		response.sendRedirect("/profile");
		}
	}
}

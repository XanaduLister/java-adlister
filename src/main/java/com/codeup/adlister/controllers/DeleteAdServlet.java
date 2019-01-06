package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (request.getSession().getAttribute("user") == null) {
//			response.sendRedirect("/login");
//			return;
//		}
//		request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
// Try grabbing the ID of the Ad to pass into deleteAdByID, instead of using deleteBtn.
		int delete = Integer.parseInt(request.getParameter("delete"));
		DaoFactory.getAdsDao().deleteAdByID(delete);

		response.sendRedirect("/profile");
	}
}

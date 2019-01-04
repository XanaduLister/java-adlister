package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = DaoFactory.getUsersDao().findById(id);
        request.setAttribute("user", user);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/update_profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        User user = DaoFactory.getUsersDao().findById(id);

        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        DaoFactory.getUsersDao().updateUser(user);
        request.getSession().invalidate();

        User userNew = DaoFactory.getUsersDao().findByUsername(request.getParameter("username"));

        request.getSession().setAttribute("user", userNew);
        request.getSession().setAttribute("profileEdited", "Profile successfully updated.");
        response.sendRedirect("/profile");

    }
}

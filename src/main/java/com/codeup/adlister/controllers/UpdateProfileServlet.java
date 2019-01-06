package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Authentication;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/update_profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || !Authentication.isExistingUser(username)
            || !Authentication.isValidEmail(email)
            || !Authentication.isExistingEmail(email)
            || !Authentication.isValidPassword(password);

        if (inputHasErrors) {
            // if any field was left blank...
            if (username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()) {
                request.setAttribute("error", "All fields are required.");
                // if a username already exists...
            } else if (!Authentication.isExistingUser(username)) {
                request.setAttribute("error", "There is already a user with that username.");
                // if an email is a valid format...
            } else if (!Authentication.isValidEmail(email)) {
                request.setAttribute("error", "This is an invalid email. Format must be -> "
                    + "(username@mail.com)");
                // if an email already exists...
            } else if (!Authentication.isExistingEmail(email)) {
                request.setAttribute("error", "There is already a user with that email.");
                // if a password is too short...
            } else if (!Authentication.isValidPassword(password)) {
                request.setAttribute("error", "Please enter valid password -> (Must be longer "
                    + "than 8 characters,"
                    + "must have one uppercase letter, one lowercase letter, one number, and a special character"
                    + "...)");
                // if any field is empty...
            } else {
                request.setAttribute("error", "Please check your information and try again.");
            }
            // Setting session attributes so registration form is still pre-filled if error occurs
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/update_profile.jsp").forward(request, response);
        } else {
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            DaoFactory.getUsersDao().updateUser(user);
            response.sendRedirect("/profile");
        }
    }
}

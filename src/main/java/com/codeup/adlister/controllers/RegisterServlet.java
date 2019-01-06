package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import com.codeup.adlister.util.Authentication;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation))
            || !Authentication.isExistingUser(username)
            || !Authentication.isValidEmail(email)
            || !Authentication.isExistingEmail(email)
            || !Authentication.isValidPassword(password)
            || !Authentication.passwordsMatching(password, passwordConfirmation);

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
                request.setAttribute("error", "Please enter valid password -> (Must be greater "
                    + "than 8 characters in length, have one uppercase letter, one lowercase "
                    + "letter, one number,"
                    + "and must have a special character...)");
                // if the passwords do not match...
            } else if (!Authentication.passwordsMatching(password, passwordConfirmation)) {
                request.setAttribute("error", "Passwords do not match.");
                // if any field is empty...
            } else {
                request.setAttribute("error", "Please check your information and try again.");
            }
            // Setting session attributes so registration form is still pre-filled if error occurs
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().invalidate();
            request.getSession().setAttribute("registered", "Registration successful. Please log in.");
            response.sendRedirect("/login");
        }
    }
}

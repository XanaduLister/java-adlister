package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Page Not Found</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Page Not Found</h1>\n" +
                "<p>Sorry, but the page you were trying to view does not exist.</p>\n" +
                "<br>\n" +
                "</body>\n" +
                "<img src=\"https://rainbowwhiskers.files.wordpress.com/2012/01/rainbowwhiskers.png\">\n" +
                "</html>");
    }
}

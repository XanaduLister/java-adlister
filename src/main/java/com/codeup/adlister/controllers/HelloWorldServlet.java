package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(
                "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">" +
                "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.1/css/all.css\" integrity=\"sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP\" crossorigin=\"anonymous\">" +
                "<style>\n" +
                "    body {\n" +
                "        background-color: lightgrey;\n" +
                "    }\n" +
                "</style>" +
                "</head>\n" +
                "<body>\n" +
                "<h1 class=\"text-center customfont text-warning\">Page Not Found</h1>\n" +
                "<p class=\"text-center\">Sorry, but the page you were trying to view does not exist.</p>\n" +
                "<br>\n" +
                "</body>\n" +
                "<div class=\"text-center\"><img src=\"https://rainbowwhiskers.files.wordpress.com/2012/01/rainbowwhiskers.png\"></div>\n" +
                "</html>");
    }
}

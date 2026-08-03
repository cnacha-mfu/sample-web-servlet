package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet maps this servlet to the URL http://localhost:8080/hello
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // called once, when the server creates the servlet
    public void init() {
        System.out.println("HelloServlet is initialized");
    }

    // called for every request (both GET and POST)
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Step 1.1: set the response content type to "text/html"

        // TODO Step 1.2: get a PrintWriter from the response and
        //                print an HTML greeting, e.g. <h1>Hello World!</h1>

        // TODO Step 2: read the "name" parameter from the request and
        //              greet that name instead, e.g. "Hello Nacha!"

    }

    // called once, when the server shuts the servlet down
    public void destroy() {
        System.out.println("HelloServlet is destroyed");
    }
}

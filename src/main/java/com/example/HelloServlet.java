package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
    //init
    public void init(){
        System.out.println("HelloServlet is initialized");
    }
    //service for both get and post
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
         // Set the response content type
        response.setContentType("text/html");

        // Obtain a PrintWriter to send HTML responses
        PrintWriter out = response.getWriter();

        // print out hello world
        out.println("Hello "+name+"!");
    }
    //destroy
    public void destroy(){
        System.out.println("HelloServlet is destroyed");
    }
}

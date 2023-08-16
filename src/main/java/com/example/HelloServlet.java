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
   
         // Set the response content type
        response.setContentType("text/html");

        // Obtain a PrintWriter to send HTML responses
        PrintWriter out = response.getWriter();

        // print out hello world
        out.println("<h1>Hello World!</h1>");
    }
    //destroy
    public void destroy(){
        System.out.println("HelloServlet is destroyed");
    }
}

package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet{
    //service method that combine two numbers and return the result
    //http://localhost:8080/calculate?num1=5&num2=7
     public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        int result = num1 + num2;
        request.setAttribute("result", result);
        // forward to jsp
        request.getRequestDispatcher("calresult.jsp").forward(request, response);
    }
}

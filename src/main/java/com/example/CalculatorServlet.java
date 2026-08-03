package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// the servlet does the LOGIC, then forwards to a JSP for the PRESENTATION
// try it with: http://localhost:8080/calculate?num1=5&num2=7
@WebServlet(urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1: read the parameters "num1" and "num2" from the request
        //         and convert them to int with Integer.parseInt(...)

        // TODO 2: add the two numbers together

        // TODO 3: store the result in a request attribute named "result"
        //         with request.setAttribute(...)

        // TODO 4: forward to calresult.jsp with
        //         request.getRequestDispatcher("calresult.jsp").forward(request, response)

    }
}

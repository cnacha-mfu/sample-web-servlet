<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello, JSP with Parameter</title>
</head>
<body>
    <%
        // Get the 'name' parameter from the request
        String name = request.getParameter("name");
        
        // Check if the 'name' parameter is not empty
        if (name != null && !name.isEmpty()) {
    %>
        <h1>Hello, <%= name %>! Welcome to JSP with Parameter Example</h1>
    <%
        } else {
    %>
        <h1>Hello, Guest! Please provide your name as a parameter.</h1>
    <%
        }
    %>
</body>
</html>

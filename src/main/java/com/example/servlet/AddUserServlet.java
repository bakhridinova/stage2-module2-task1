package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.util.AttributeParameterHolder.*;
import static com.example.util.PageNavigation.ADD_USER_PAGE;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ADD_USER_PAGE);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter(REQUEST_PARAMETER_USER_FIRST_NAME);
        String lastName = request.getParameter(REQUEST_PARAMETER_USER_LAST_NAME);
        Warehouse warehouse = Warehouse.getInstance();
        User user = new User(firstName, lastName);
        warehouse.addUser(user);

        request.setAttribute(REQUEST_ATTRIBUTE_USER_FIRST_NAME, firstName);
        request.setAttribute(REQUEST_ATTRIBUTE_USER_LAST_NAME, lastName);

        try{
            response.sendRedirect("/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

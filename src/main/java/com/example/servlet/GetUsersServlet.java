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
import java.util.Set;

import static com.example.util.AttributeParameterHolder.REQUEST_ATTRIBUTE_USERS;
import static com.example.util.PageNavigation.GET_USERS_PAGE;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Set<User> users = Warehouse.getInstance().getUsers();
        request.setAttribute(REQUEST_ATTRIBUTE_USERS, users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(GET_USERS_PAGE);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}

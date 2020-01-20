package controllers;

import dao.DbManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    private DbManager dbManager;

    public void init() throws ServletException {

        dbManager = new DbManager();
        dbManager.setConnection();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password =request.getParameter("password");
        dbManager.addUser(new User(null, name, password));
        response.sendRedirect("/");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ArrayList<User> users = dbManager.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}

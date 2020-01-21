package controllers;

import dao.DbManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    DbManager dbManager;

    @Override
    public void init() throws ServletException {
        dbManager = new DbManager();
        dbManager.setConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = dbManager.getUserById(String.valueOf(id));
        if(user!=null){
            request.setAttribute("user", user);
            request.getRequestDispatcher("detail.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/").forward(request, response);
        }

    }
}

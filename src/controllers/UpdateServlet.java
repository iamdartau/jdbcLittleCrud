package controllers;

import dao.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {

    private DbManager dbManager;

    @Override
    public void init() throws ServletException {
        dbManager = new DbManager();
        dbManager.setConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id =request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        dbManager.updateUserById(id, name, password);
        request.getRequestDispatcher("/").forward(request, response);
    }

}

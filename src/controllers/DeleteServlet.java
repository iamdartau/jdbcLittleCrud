package controllers;

import dao.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    DbManager dbManager;

    @Override
    public void init() throws ServletException {
        dbManager = new DbManager();
        dbManager.setConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        dbManager.deleteuser(id);

        response.sendRedirect("/");
    }
}

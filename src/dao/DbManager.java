package dao;

import models.User;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    private Connection connection;

    public void setConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/littlecrud?useUnicode=true&serverTimezone=UTC","root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new  ArrayList<User>();

        try {

            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                users.add(new User(id,name, password));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public void addUser(User user){
        try {

            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO `users`(`id`, `name`, `password`) VALUES (null ,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteuser(String id) {
        String sql = "delete from users where id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(String id){
        String sql = "select from users where id = ?";
        User user = null;
        try {
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String user_id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                user = new  User(user_id,name, password);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void updateUserById(String id, String name, String password) {

        try {
            PreparedStatement statement = connection.prepareStatement("update littlecrud.users set name = ?, password = ? where id = ?");
            statement.setString(2,id);
            statement.setString(1,name);
            statement.setString(3,password);
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

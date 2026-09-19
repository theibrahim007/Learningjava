package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/task";
        String username = "root";
        String password = "root123";   // ⭐ YOUR MySQL password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package coreJava16.TaskJdbc3.classes;

import coreJava16.TaskJdbc3.MyConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionImpl implements MyConnection {
    @Override
    public Connection getMyConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "root", "root");
            if (connection == null) {
                System.out.println("Connection Failed");
            } else {
                System.out.println("Connection Success!!!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

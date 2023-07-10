package coreJava16.TaskJdbc3.classes;

import coreJava16.TaskJdbc3.CreateTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableImpl implements CreateTable {

    @Override
    public boolean createThisTable(Connection conn) {
        try {
            String createTable = "Create table Product (Pid int, Pname varchar(25), Qty int, price float(10,7))";
            PreparedStatement preparedStatement = conn.prepareStatement(createTable);

            boolean success = preparedStatement.execute();
            if(!success){
                System.out.println("Success, Product table created!!!");
                return true;
            }
            else {
                System.out.println("Table creation failed");
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}

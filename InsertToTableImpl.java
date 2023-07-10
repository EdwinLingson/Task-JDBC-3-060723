package coreJava16.TaskJdbc3.classes;

import coreJava10.bankTask.TakeInput;
import coreJava16.TaskJdbc3.InsertToTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertToTableImpl implements InsertToTable {
    @Override
    public boolean insertThis(Connection connection) {
        int pid;
        String pName;
        int qty;
        float price;
        int noOfProducts;
        try {
            noOfProducts = TakeInput.readInteger("How many products you want to add?");
            String sqlStmt = "Insert into Product values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStmt);
            for (int ctr = 0; ctr < noOfProducts; ctr++) {
                System.out.println("Enter Details of Product "+(ctr+1));
                pid = TakeInput.nullCheck(TakeInput.readInteger("Enter Product Id"));
                pName = TakeInput.readString("Enter Product Name\n");
                qty = TakeInput.nullCheck(TakeInput.readInteger("Enter Quantity"));
                price = TakeInput.readFloat("Enter Price");
                preparedStatement.setInt(1,pid);
                preparedStatement.setString(2,pName);
                preparedStatement.setInt(3,qty);
                preparedStatement.setFloat(4,price);
//                System.out.println(sqlStmt);
                int success = preparedStatement.executeUpdate();
                if(success == 1){
                    System.out.println("Success, Product: " + pid + " is inserted successfully");

                }
                else {
                    System.out.println("Failed, Product: " + pid + " is failed to get inserted");
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }
}
/*
	101	Shoes	300	20.3400002
	102	Socks	35	2.0000000
	103	Cap	50	6.0000000
	104	Shirt	23	10.9899998
	105	Trousers	30	6.9899998
 */
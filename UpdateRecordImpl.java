package coreJava16.TaskJdbc3.classes;

import coreJava10.bankTask.TakeInput;
import coreJava16.TaskJdbc3.UpdateRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecordImpl implements UpdateRecord {
    @Override
    public void updateProductName(Connection connection, int pid, String pname) {
        try {

            String sqlStmt = "update Product set Pname = ? where Pid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStmt);
            preparedStatement.setString(1,pname);
            preparedStatement.setInt(2,pid);
            int status = preparedStatement.executeUpdate();
            if(status==1) System.out.println("Name Updated");
            else System.out.println("Update Failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateQty(Connection connection, int pid, int newQty) {
        try {

            String sqlStmt = "update Product set Qty = ? where Pid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStmt);
            preparedStatement.setInt(1,newQty);
            preparedStatement.setInt(2,pid);
            int status = preparedStatement.executeUpdate();
            if(status==1) System.out.println("Quantity Updated");
            else System.out.println("Update Failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePrice(Connection connection, int pid, float newPrice) {
        try {

            String sqlStmt = "update Product set Qty = ? where Pid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStmt);
            preparedStatement.setFloat(1,newPrice);
            preparedStatement.setInt(2,pid);
            int status = preparedStatement.executeUpdate();
            if(status==1) System.out.println("Price Updated");
            else System.out.println("Update Failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Connection connection) {
        int pid = TakeInput.nullCheck(TakeInput.readInteger("Enter the PID to update\n"));
        int selection;
        do {
            System.out.println("What do you want to update\n1.Name\n2.Quantity\n3.Price\n4.Exit");
            selection =TakeInput.nullCheck(TakeInput.readInteger());
            switch (selection){
                case 1:String newName = TakeInput.readString("Enter new name"); updateProductName(connection,pid,newName);break;
                case 2:int newQty = TakeInput.nullCheck(TakeInput.readInteger("Enter New Quantity")); updateQty(connection,pid,newQty); break;
                case 3: float newPrice = TakeInput.readFloat("Enter new Price");updatePrice(connection,pid,newPrice);break;
                default:
                    System.out.println("Enter valid Option");
            }
        }while (selection!=4);
    }
}

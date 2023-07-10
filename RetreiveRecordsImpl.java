package coreJava16.TaskJdbc3.classes;

import coreJava16.TaskJdbc3.RetreiveRecords;

import java.sql.*;

public class RetreiveRecordsImpl implements RetreiveRecords {
    @Override
    public void getAllRecords(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery("Select * from product");
            while (rs.next()){
                System.out.println(rs.getInt(1) + " "+rs.getString(2) + " "+rs.getInt(3) + " "+rs.getFloat(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getRecord(Connection connection, int pid) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from Product where pid = ?");
            preparedStatement.setInt(1,pid);
            ResultSet rs  =preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1) + " "+rs.getString(2) + " "+rs.getInt(3) + " "+rs.getFloat(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

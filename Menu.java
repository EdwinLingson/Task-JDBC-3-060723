package coreJava16.TaskJdbc3.classes;

import coreJava10.bankTask.TakeInput;
import coreJava16.TaskJdbc3.*;

import java.sql.Connection;
import java.util.Comparator;

public class Menu {
    CreateTable createTable;
    InsertToTable insertToTable;
    MyConnection myConnection;
    RetreiveRecords retreiveRecords;
    UpdateRecord updateRecord;
    Connection connection;
    public Menu(){
        myConnection = new MyConnectionImpl();
        createTable = new CreateTableImpl();
        insertToTable = new InsertToTableImpl();
        retreiveRecords = new RetreiveRecordsImpl();
        updateRecord = new UpdateRecordImpl();
        connection = myConnection.getMyConnection();
    }
    public void start(){
        int selection;
        do {
            System.out.println("1.Create Table\n2.Insert into Table\n3.Retreive all Records\n4.Retrieve a  Record\n5.Update Record\n6.Exit");
            selection = TakeInput.nullCheck(TakeInput.readInteger());
            switch (selection){
                case 1: createTable.createThisTable(connection);break;
                case 2: insertToTable.insertThis(connection); break;
                case 3: retreiveRecords.getAllRecords(connection);break;
                case 4: int pid = TakeInput.nullCheck(TakeInput.readInteger("Enter PID to be searched"));retreiveRecords.getRecord(connection,pid);break;
                case 5: updateRecord.update(connection);break;
            }
        }
        while ((selection!=6));
    }
}

package coreJava16.TaskJdbc3;

import java.sql.Connection;

public interface RetreiveRecords {
    void getAllRecords(Connection connection);
    void getRecord(Connection connection,int pid);
}

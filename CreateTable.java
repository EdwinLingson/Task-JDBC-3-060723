package coreJava16.TaskJdbc3;

import java.sql.Connection;

public interface CreateTable {
    boolean createThisTable(Connection conn);
}

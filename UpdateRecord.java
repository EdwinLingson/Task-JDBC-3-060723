package coreJava16.TaskJdbc3;

import java.sql.Connection;

public interface UpdateRecord {
    void updateProductName(Connection connection, int pid, String pname);
    void updateQty(Connection connection, int pid, int newQty);
    void updatePrice(Connection connection, int pid, float newPrice);
    void update(Connection connection);
}

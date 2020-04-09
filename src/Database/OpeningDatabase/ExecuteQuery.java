package Database.OpeningDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {
    static String sql;
    static int choice;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void executeQuery(Connection c, String Account, String Pass, int f) throws NumberFormatException, IOException, SQLException {
        sql = TableFormation.insertTable(c, Account, Pass);
        try {
            Statement stmt = c.createStatement();
            if (f == 1) {
                stmt.addBatch("CREATE TABLE Account_Details (Account_Name VARCHAR(25),Password VARCHAR(25))");
                stmt.addBatch(sql);
                stmt.executeBatch();
            } else {
                stmt.addBatch(sql);
                stmt.executeBatch();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        c.close();
    }
}

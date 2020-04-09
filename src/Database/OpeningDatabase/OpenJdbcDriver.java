package Database.OpeningDatabase;

;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OpenJdbcDriver {
    public static void openJdbcDriver(String Account, String Pass, int f, String mySql_Account, String mySql_Pass) {

        Connection conn = null;

        try {
            String url = "jdbc:oracle:thin:@192.168.144.254:1521:xe";
            conn = DriverManager.getConnection(url, "netmanage", "crestiki");
            new ExecuteQuery();
            try {
                ExecuteQuery.executeQuery(conn, Account, Pass, f);
            } catch (NumberFormatException e) {
                System.out.println("Error in Database Operartion");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error in Database Operartion");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Connection is not established");
            e.printStackTrace();
        }
    }
}

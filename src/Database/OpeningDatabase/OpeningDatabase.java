package Database.OpeningDatabase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OpeningDatabase {
    static int f = 0;

    public static void openingDatabase(String Account, String Pass, String mySql_Account, String mySql_Pass) {
        Connection conn = null;

        try {
            String url = "jdbc:oracle:thin:@192.168.144.254:1521:xe";
            conn = DriverManager.getConnection(url, "netmanage", "crestiki");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", mySql_Account, mySql_Pass);
            try {
                DatabaseMetaData dbmd = conn.getMetaData();
                ResultSet rs = dbmd.getCatalogs();
                while (rs.next()) {

                    if (rs.getString(1).matches("testpv"))
                        f = 0;
                    else
                        f = 1;
                }
                if (f == 1) {
                    Statement stmt = conn.createStatement();
                    stmt.addBatch("CREATE table TestPV");
                    //stmt.addBatch("USE TestPV");
                    stmt.executeBatch();
                }

            } catch (SQLException e) {
                System.out.println("Error in Database display.");
                e.printStackTrace();
            } finally {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Connection is not established");
            e.printStackTrace();
        }
        new OpenJdbcDriver();
        OpenJdbcDriver.openJdbcDriver(Account, Pass, f, mySql_Account, mySql_Pass);
    }
}

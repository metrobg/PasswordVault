package Database;


import java.io.IOException;
import java.util.Scanner;

import Database.OpeningDatabase.*;

public class DatabaseProperty {
    static Scanner sc = new Scanner(System.in);

    public static void databaseProperty(String Account, String Pass, String mySql_Account, String mySql_Pass) throws IOException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            new OpeningDatabase();
            OpeningDatabase.openingDatabase(Account, Pass, mySql_Account, mySql_Pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found.");
            e.printStackTrace();
        }
    }
   /* public static Connection getConnection() throws SQLException {
        try {
            Connection dbConnection = DriverManager.getConnection(Oracleurl, "netmanage", "crestiki");
            dbConnection.setAutoCommit(false);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to connect to Oracle");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }*/

}


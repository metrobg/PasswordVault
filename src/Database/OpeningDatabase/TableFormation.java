package Database.OpeningDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;


public class TableFormation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String sql;
    static String tablename;
    static String columnname;
    static String datatype;
    static String value;
    static String sqlcondition;

    static String sql1;
    static String sql2;
    static int columncount;
    static int size;

    public static String insertTable(Connection c, String Account, String Pass) throws IOException {

        sql = "INSERT INTO Account_Details ";
        sql1 = sql1 + "Account_Name, Password" + ",";
        sql2 = sql2 + "'" + Account + "'" + "," + "'" + Pass + "'" + ",";
        sql1 = sql1.replaceAll(",$", "");
        sql2 = sql2.replaceAll(",$", "");
        sql = sql + "(" + sql1 + ")" + " VALUES (" + sql2 + ");";
        sql = sql.replaceAll("null", "");
        return sql;

    }
}
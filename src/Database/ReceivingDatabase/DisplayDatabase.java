package Database.ReceivingDatabase;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;


public class DisplayDatabase {
    @SuppressWarnings("rawtypes")
    private static ObservableList<ObservableList> data;
    private static String Oracleurl = "jdbc:oracle:thin:@192.168.144.234:1521:gpdc";

    //Connection database
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Connection getConnection() throws SQLException {
        try {
            Connection dbConnection = DriverManager.getConnection(Oracleurl, "develope", "merlin");
            dbConnection.setAutoCommit(false);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to connect to Oracle");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }

    public static void buildData(TableView tableview, String mySql_Account, String mySql_Pass) {
        Connection c;
        data = FXCollections.observableArrayList();
        try {
            c = (Connection) getConnection();
            String SQL = "SELECT * from Account_Details";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {

                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {

                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableview.getColumns().addAll(col);
            }
            while (rs.next()) {

                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                    row.add(rs.getString(i));
                }

                data.add(row);
            }

            tableview.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
}
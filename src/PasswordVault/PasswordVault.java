package PasswordVault;

import java.io.IOException;

//import MySql.DatabaseProperty;
//import MySql.ReceivingDatabase.DisplayDatabase;
import Database.DatabaseProperty;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PasswordVault extends Application {

    String t1, t2;
    int f1 = 0, f2 = 0, f3 = 0, f4 = 0;
    ;
    GridPane grid1 = new GridPane();
    GridPane grid2 = new GridPane();
    GridPane grid3 = new GridPane();
    GridPane mySql_grid = new GridPane();
    Text scenetitle1, scenetitle2, scenetitle3, mySql_scenetitle;
    Label userName1, userName2, userName3, mySql_userName;
    TextField userTextField1, userTextField2, userTextField3, mySql_userTextField;
    Label pw1, pw2, pw3, mySql_pw;
    PasswordField pwBox1, pwBox2, pwBox3, mySql_pwBox;
    Button btn1, btn2, btn3, btn4, mySql_btn;
    HBox hbbtn1, hbBtn2, hbBtn3, hbBtn4, mySql_hbBtn;
    //TableView
    @SuppressWarnings("rawtypes")
    TableView tableview = new TableView();

    Scene scene1 = new Scene(grid1, 300, 275);
    Scene mySql_scene = new Scene(mySql_grid, 325, 275);
    Scene scene2 = new Scene(grid2, 300, 300);
    Scene scene3 = new Scene(tableview, 700, 500);

    //===============================================================================================================================================
    @Override
    public void start(Stage primaryStage) {
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        scenetitle1 = new Text("User Authentication");
        scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid1.add(scenetitle1, 0, 0, 2, 1);

        userName1 = new Label("User Name:");
        grid1.add(userName1, 0, 1);

        userTextField1 = new TextField();
        grid1.add(userTextField1, 1, 1);
        pw1 = new Label("Password:");
        grid1.add(pw1, 0, 2);
        pwBox1 = new PasswordField();
        grid1.add(pwBox1, 1, 2);

        btn1 = new Button("Log in");
        hbbtn1 = new HBox(10);
        hbbtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbbtn1.getChildren().add(btn1);
        grid1.add(hbbtn1, 1, 4);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Password Vault");
        primaryStage.show();

        //============================================================================================================================================

        mySql_grid.setAlignment(Pos.CENTER);
        mySql_grid.setHgap(10);
        mySql_grid.setVgap(10);
        mySql_grid.setPadding(new Insets(25, 25, 25, 25));
        mySql_scenetitle = new Text("MYSQL DataBase Authentication");
        mySql_scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        mySql_grid.add(mySql_scenetitle, 0, 0, 2, 1);

        mySql_userName = new Label("User Name:");
        mySql_grid.add(mySql_userName, 0, 1);

        mySql_userTextField = new TextField();
        mySql_grid.add(mySql_userTextField, 1, 1);
        mySql_pw = new Label("Password:");
        mySql_grid.add(mySql_pw, 0, 2);
        mySql_pwBox = new PasswordField();
        mySql_grid.add(mySql_pwBox, 1, 2);

        mySql_btn = new Button("Submit");
        mySql_hbBtn = new HBox(10);
        mySql_hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        mySql_hbBtn.getChildren().add(mySql_btn);
        mySql_grid.add(mySql_hbBtn, 1, 4);


        //=============================================================================================================================================
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        scenetitle2 = new Text("Welcome to Password Vault");
        scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid2.add(scenetitle2, 0, 0, 2, 1);

        userName2 = new Label("Account name:");
        grid2.add(userName2, 0, 2);

        userTextField2 = new TextField();
        grid2.add(userTextField2, 1, 2);
        pw2 = new Label("Password:");
        grid2.add(pw2, 0, 3);
        pwBox2 = new PasswordField();
        grid2.add(pwBox2, 1, 3);
        btn2 = new Button("Save");

        hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(btn2);
        grid2.add(hbBtn2, 1, 5);

        btn3 = new Button("Display");
        hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BASELINE_CENTER);
        hbBtn3.getChildren().add(btn3);
        grid2.add(hbBtn3, 1, 7);

        //==========================================================================================================================================

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //============================================================================================================================================
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (userTextField1.getText().equals("ggraves")) {
                    if (pwBox1.getText().equals("12345")) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText(null);
                        alert.setContentText("Login is successfull");
                        alert.show();
                        primaryStage.setScene(mySql_scene);
                        primaryStage.setTitle("Password Vault");
                        primaryStage.show();

                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Login is unsuccessful");
                        alert.show();

                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Login is unsuccessful");
                    alert.show();

                }
            }
        });
        //=============================================================================================================================================

        mySql_btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                t1 = mySql_userTextField.getText();
                t2 = mySql_pwBox.getText();
                primaryStage.setScene(scene2);
                primaryStage.setTitle("Password Vault");
                primaryStage.show();


            }
        });

        //============================================================================================================================================

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                if (userTextField2.getText().equals("") || pwBox2.getText().equals("")) {

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Empty Account name or Password field");
                    alert.show();

                } else {

                    String Account = userTextField2.getText();
                    String Pass = pwBox2.getText();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    try {
                        DatabaseProperty.databaseProperty(Account, Pass, t1, t2);
                    } catch (IOException e1) {
                    } catch (Exception e1) {
                        alert.setContentText("Save is unsuccessful");
                        e1.printStackTrace();
                    }
                    alert.setContentText("Save is successful");
                    //alert.show();

                }

            }

        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //  DisplayDatabase.buildData(tableview, t1, t2);
                primaryStage.setScene(scene3);
                primaryStage.show();
            }

        });
    }
//==================================================================================================================================================================================

    public static void main(String args) {
        launch(args);

    }
}



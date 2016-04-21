/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;


import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    private Button btn1;

    @FXML
    private TextField UserField;

    @FXML
    private TextField PassField;

    @FXML
    private Label errorLabel;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ValidCredentials()) {
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();


        } else {
            UserField.clear();
            PassField.clear();
            errorLabel.setText("Please Check Your Info and Try Again");

        }

    }


    private boolean ValidCredentials() throws SQLException {
        boolean let_in = false;
        System.out.println("SELECT * FROM userTbl WHERE userID= " + "'" + UserField.getText() + "'" + "AND pass= " + "'" + PassField.getText() + "'");

        Connection c = null;
        java.sql.Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:login.db");
            c.setAutoCommit(false);

            System.out.println("Successful Database Query");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM userTbl WHERE userID= " + "'" + UserField.getText() + "'" + "AND pass= " + "'" + PassField.getText() + "'");

            while (rs.next()) {
                if (rs.getString("userID") != null && rs.getString("pass") != null) {
                    java.lang.String username = rs.getString("userID");
                    System.out.println("userID = " + username);
                    java.lang.String password = rs.getString("pass");
                    System.out.println("pass = " + password);
                    let_in = true;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Successful");
        return let_in;


    }
}
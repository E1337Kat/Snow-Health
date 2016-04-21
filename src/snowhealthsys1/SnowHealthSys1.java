/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hunter
 */
public class SnowHealthSys1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

  

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Snow Health System");
        primaryStage.setScene(new Scene(root));

        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
}

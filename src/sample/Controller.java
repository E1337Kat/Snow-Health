package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{


@FXML
    private Button btn1;



            @FXML
            private void handleButtonAction(ActionEvent event) throws IOException {
                Stage stage = null;
                Parent root = null;
                if(event.getSource()==btn1){
                    stage=(Stage) btn1.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();


                }





    @Override
    public void initialize(URL url, ResourceBundle rb){




    }
}

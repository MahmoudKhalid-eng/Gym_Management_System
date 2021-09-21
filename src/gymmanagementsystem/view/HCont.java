
package gymmanagementsystem.view;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class HCont {
    @FXML
    Button cl,session,about;
    @FXML
    Button training;
    public void cls(Event e) throws IOException{
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Client_Page.fxml"));        
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.setTitle("Clients");
        stage.show();
        
    }
    public void trainings(Event e) throws IOException{
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Trainings.fxml"));
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.setTitle("Trainings");
        stage.show();
    }
    public void sessions(Event e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Scan.fxml"));
        Stage stage = new Stage();
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.setTitle("Sessions");
        stage.show();
    }
    public void abouts(Event e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Abouts.fxml"));
        Scene sc = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setResizable(false);
        stage.setTitle("About us");
        stage.show();
    }
    
}

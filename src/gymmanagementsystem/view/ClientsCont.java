
package gymmanagementsystem.view;

import gymmanagementsystem.CallBack;
import gymmanagementsystem.control.Clients_Control;
import gymmanagementsystem.model.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ClientsCont implements Initializable,CallBack{
    @FXML
    ImageView ref;
    @FXML
    Button home,ins,update,dlt,srchh,tr,ses,abo;
    @FXML
    TableColumn c1,c2,c3,c4,c5,c6;
    @FXML
    public TableView tv;
    @FXML
    TextField key;
    Clients_Control cc = new Clients_Control();
    ObservableList<Client> allClients;
    
    public void homes(Event e) throws IOException{
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Home.fxml"));
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.setTitle("Clients");
        stage.show();
    }
    public void insert1() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gymmanagementsystem/view/Insert.fxml"));
        Parent root = loader.load();
        InsertCont cont = loader.getController();
        cont.cl = this;
        Scene sc = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setTitle("Insert");
        stage.show();
    }
    public void update1() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Update.fxml"));
        Scene sc = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setTitle("Update");
        stage.show();
    }
    public void delete1() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Delete.fxml"));
        Scene sc = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setTitle("Delete");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setCellValueFactory(new PropertyValueFactory<>("idd"));
        c2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        c3.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        c4.setCellValueFactory(new PropertyValueFactory<>("Emergency"));
        c5.setCellValueFactory(new PropertyValueFactory<>("Type"));
        c6.setCellValueFactory(new PropertyValueFactory<>("sessions"));
        allClients = cc.getAllClients();
        tv.setItems(allClients);
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
    public void srch(Event e) throws SQLException{
        tv.setItems(cc.getClient(Integer.parseInt(key.getText())));
    }
    public void refresh(){
        tv.setItems(cc.getAllClients());
        key.setText("");
    }
    public TableView send(){
        return tv;
    }

    @Override
    public void refresh(Client c) {
        allClients.add(c);
    }
}

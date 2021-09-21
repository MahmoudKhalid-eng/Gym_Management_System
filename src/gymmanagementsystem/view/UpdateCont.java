
package gymmanagementsystem.view;

import gymmanagementsystem.control.Search_Control;
import gymmanagementsystem.control.Update_Control;
import gymmanagementsystem.model.Client;
import gymmanagementsystem.model.SearchRes;
import java.sql.SQLException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class UpdateCont {
    @FXML
    TextField key,name,phone,emergency,type,sessions;
    @FXML
    Button srch,updt;
    @FXML
    Label res;
    Search_Control sc = new Search_Control();
    public void search(Event e) throws SQLException{
        int id = Integer.parseInt(key.getText());
        try{
            if(sc.idCheck(id)){
                Client rr = sc.search(id);
                res.setText("Found");
                name.setText(rr.getName());
                phone.setText(rr.getPhone());
                emergency.setText(rr.getEmergency());
                type.setText(rr.getType());
                sessions.setText(Integer.toString(rr.getSessions()));
                res.setStyle("-fx-text-fill: green;");
            }
            
            else{
                res.setStyle("-fx-text-fill: red;");
                res.setText("Not Found");
                name.setText("");
                phone.setText("");
                emergency.setText("");
                type.setText("");
                sessions.setText("");
            }
            
        }
        catch(Exception ee){
            System.out.println(ee.getMessage());
        }
    }
    public void update(){
        int id = Integer.parseInt(key.getText());
        Update_Control uc = new Update_Control();
        uc.update(id, name.getText(), phone.getText(), emergency.getText(), type.getText(), Integer.parseInt(sessions.getText()));
        key.setText("");
        res.setText("");
        name.setText("");
        phone.setText("");
        emergency.setText("");
        type.setText("");
        sessions.setText("");
    }
}

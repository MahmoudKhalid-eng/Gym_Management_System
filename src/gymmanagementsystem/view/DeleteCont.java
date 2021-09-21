
package gymmanagementsystem.view;

import gymmanagementsystem.control.Delete_Control;
import gymmanagementsystem.control.Search_Control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DeleteCont {
    @FXML
    TextField key;
    @FXML
    Button dlt;
    @FXML
    Label res;
    Delete_Control dc = new Delete_Control();
    Search_Control sc = new Search_Control();
    public void delete1(Event e){
        int id = Integer.parseInt(key.getText());
        if(sc.idCheck(id)){
            dc.delete(id);
            res.setText("Deleted");
        }
        else{
            res.setText("Not Found ID");
        }
        
    }
    
}

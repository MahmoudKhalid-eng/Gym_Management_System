
package gymmanagementsystem.view;

import gymmanagementsystem.control.Scan_Control;
import gymmanagementsystem.control.Search_Control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ScanCont {
    @FXML
    Label res;
    @FXML
    Button btn;
    @FXML
    TextField key;
    Scan_Control sc = new Scan_Control();
    Search_Control scc = new Search_Control();
    public void scn(Event e){
        int id = Integer.parseInt(key.getText());
        int ress = sc.scan(id);
        if(scc.idCheck(id)){
            if(ress>0){
                res.setText("Remainder: "+ress);
            }
            else{
                res.setText("Finished");
            }
        }
        else{
            res.setText("Not Found ID");
        }
        
    }
}

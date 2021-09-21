
package gymmanagementsystem.view;

import gymmanagementsystem.control.Login_Control;
import gymmanagementsystem.model.Admin;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginCont {
    @FXML
    TextField txt1;
    @FXML
    PasswordField txt2;
    @FXML
    Button btnlog;
    @FXML
    Label msg;
    Admin ad = new Admin();
    Login_Control lg = new Login_Control();
    public void isLogin(Event e) throws SQLException, IOException{
        ad.setUsername(txt1.getText());
        ad.setPassword(txt2.getText());
        if(lg.isAdmin(ad)){
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root;
            try{
                root = FXMLLoader.load(getClass().getResource("/gymmanagementsystem/view/Home.fxml"));
                Scene sc = new Scene(root);
                stage.setScene(sc);
                stage.setTitle("Home");
                stage.setMaximized(true);
                stage.show();
            }
            catch(IOException ee){
                System.out.println(ee.getMessage());
            }
            
        }
        else{
            msg.setText("Incorrect username ot password");
        }
    }
}

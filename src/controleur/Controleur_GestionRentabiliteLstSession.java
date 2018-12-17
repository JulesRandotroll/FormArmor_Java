//Controleur_GestionRentabiliteLstSession
package controleur;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import modele.gesSession;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class Controleur_GestionRentabiliteLstSession implements Initializable
{
    private MainApp mainApp;
    
    @FXML
    ListView lst_sessions;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }   
    
    public void setMainApp(MainApp MainApp)
    {
        //System.out.println("MainApp set ?");
        this.mainApp = MainApp;
        //System.out.println("MainApp set !");
    }
    
    
    private void remplirLstSession() throws SQLException
    {
        ObservableList obsList = gesSession.getSessionClose();
        lst_sessions.setItems(obsList);
    }
}

//Controleur_GestionRentabiliteLstSession
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class Controleur_GestionRentabiliteLstSession implements Initializable
{
    private MainApp mainApp;
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
    
}

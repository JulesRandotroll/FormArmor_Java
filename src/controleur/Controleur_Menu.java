//Controleur_Menu

package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Deborah G
 */
public class Controleur_Menu implements Initializable 
{
    private MainApp mainApp;

    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         // modif 7
    }   
    
    public void setMainApp(MainApp MainApp)
    {
        //System.out.println("MainApp set ?");
        this.mainApp = MainApp;
        //System.out.println("MainApp set !");
    }
    
    @FXML
    public void handleMenuAccueil()
    {
        //System.out.println("Menu Affiche accueil");
        mainApp.affichageAccueil();
    }
    
    @FXML 
    public void handleMenuInsciption()
    {
        //System.out.println("Menu Affiche Inscription");
        mainApp.affichageInscription();
    }
    
    @FXML
    public void handleQuitter() throws Exception
    {
        mainApp.quitterAppli();
    }
    
    @FXML
    public void handleMenuGestionRentabilite()
    {
        mainApp.afficherGestionRentabilite();
    }
    
    @FXML
    public void handleMenuSession()
    {
        mainApp.afficherGestionSession();
    }

}

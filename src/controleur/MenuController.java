/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
//controleur.MenuController
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Deborah G
 */
public class MenuController implements Initializable 
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
    
    
}

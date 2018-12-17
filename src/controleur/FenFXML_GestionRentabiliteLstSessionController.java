/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class FenFXML_GestionRentabiliteLstSessionController implements Initializable
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

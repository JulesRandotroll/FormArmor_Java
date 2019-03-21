//Controleur_GestionRentabiliteLstSession
package controleur;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import modele.Session_Formation;
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
        try
        {
            // TODO
            remplirLstSession();
        } catch (SQLException ex)
        {
            System.out.println("ERREUR Initialisation GestionRentabilitéLstSession : "+ ex.getMessage());
            Logger.getLogger(Controleur_GestionRentabiliteLstSession.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        System.out.println("Taille Liste : "+ obsList.size());
        for(int i = 0; i< obsList.size(); i++)
        {
            System.out.println("Une Session : "+((Session_Formation) obsList.get(i)).getFormation().getLibelle());
        }
        lst_sessions.setItems(obsList);
    }

    @FXML
    private void afficherSessionSelectionnee()
    {
        Session_Formation uneSession = (Session_Formation) lst_sessions.getSelectionModel().getSelectedItem();
        System.out.println(uneSession.toString());
        mainApp.setMaSession_Formation(uneSession);
        mainApp.afficherGestionRentabiliteSessionSelectionnee();
        
    }


}

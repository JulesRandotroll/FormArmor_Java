/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modele.Client;
import modele.Session;

/**
 *
 * @author Philippe
 */
public class MainApp extends Application
{
    private Stage primaryStage;
    private static BorderPane  rootLayout;

    // Pour conserver la session sélectionnée dans le TableView de la fenêtre inscription
    private static Session maSessionSelectionne;
    // Pour conserver le client sélectionné dans le ComboBox de la fenêtre inscription
    private static Client monClientSelectionne;
    
    


//Passage au code : 

    public MainApp()
    {
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FormArmor");
        try
        {
            //this.primaryStage.setTitle("Gestion des inscriptions aux sessions de formations");
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/Menu.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        
            MenuController controller = loader.getController();
            controller.setMainApp(this);
            
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement fenetre principale : " + e.getMessage());
        }
        affichageAccueil();

    }
    
       public Stage getPrimaryStage()
    {
        return primaryStage;
    }
    
    
    //Affichages pages principales : 
    public void affichageAccueil() 
    {
        //System.out.println("mainApp Affiche Accueil");
        try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/Accueil.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void affichageInscription()
    {
        //System.out.println("mainApp affiche Inscritpion");
        try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/FenFXML_Inscription.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void afficherGestionRentabilite()
    {
        try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/FenFXML_GestionRentabiliteLstSession.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
            
            //Necessaire pour créer une fenêtre modale
            FenFXML_GestionRentabiliteLstSessionController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
 
 //Pages modales : 
    //AffichageGestionRentabilite page modale : 
    



    
    
    
    
    
    
    
    
    
    
    
    
    
    public void quitterAppli() throws Exception
    {
        this.stop();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void creationFenConfirm()
    {
        
    }

    // Getter et Setter pour l'item selectionné dans le tableView des sessions (fenetre Inscription)
    public static void setMaSessionSelectionnee(Session maSession)
    {
        maSessionSelectionne = maSession;
    }
    public static Session getMaSessionSelectionnee()
    {
        return maSessionSelectionne;
    }
    // Getter et Setter pour l'item selectionné dans le ComboBox des clients (fenetre Inscription)
    public static void setMonClientSelectionne(Client monClient)
    {
        monClientSelectionne = monClient;
    }
    public static Client getMonClientSelectionne()
    {
        return monClientSelectionne;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
   



}

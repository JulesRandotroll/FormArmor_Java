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
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Client;
import modele.Session;
import modele.Session_Formation;


public class MainApp extends Application
{
    private Stage primaryStage, secondaryStage;
    private static BorderPane  rootLayout;

    // Pour conserver la session sélectionnée dans le TableView de la fenêtre inscription
    private static Session maSessionSelectionne;
    // Pour conserver le client sélectionné dans le ComboBox de la fenêtre inscription
    private static Client monClientSelectionne;
    // Pour conserver la session et la formation sélectionnées par le client 
    private static Session_Formation maSession_Formation;

    public static Session_Formation getMaSession_Formation()
    {
        return maSession_Formation;
    }

    public static void setMaSession_Formation(Session_Formation maSession_Formation)
    {
        MainApp.maSession_Formation = maSession_Formation;
    }
    
    


//Passage au code : 

    public MainApp()
    {
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        // le plop arrive t'il ? t'aime
        
        
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
        
            Controleur_Menu controller = loader.getController();
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
        try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/Inscription.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void afficherGestionSession()
    {
            try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/GestionSession.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
        }
        catch(IOException e)
        {
            System.out.println("PLOP : "+ e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void afficherGestionRentabilite()
    {
        /*try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/GestionRentabiliteSessions.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
            
            //Necessaire pour créer une fenêtre modale
            Controlleur_GestionRentabiliteSessions controller = loader.getController();
            controller.setMainApp(this);
            
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/
        try
        {
            secondaryStage = new Stage();
            secondaryStage.setTitle("Gestion rentabilité");
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/GestionRentabiliteSessions.fxml"));

             AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            secondaryStage.setScene(scene);
            secondaryStage.initOwner(primaryStage);
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.show();
            
            
            /*
                Controlleur_GestionRentabiliteSessions controller = loader.getController();
                controller.setMainApp(this);
                dialog.initOwner(parentStage);
                dialog.initModality(Modality.APPLICATION_MODAL); 
                dialog.showAndWait();
            */
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
    
    public void afficherGestionRentabiliteSessionSelectionnee()
    {
        try
        {
            FXMLLoader loader=new FXMLLoader(MainApp.class.getResource("/vue/GestionRentabiliteSessionSelect.fxml"));
            AnchorPane overviewPage=(AnchorPane)loader.load();
            rootLayout.setCenter(overviewPage);    
            
            //Necessaire pour créer une fenêtre modale
            Controleur_GestionRentabiliteSessionSelect controller = loader.getController();
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
        System.exit(0);
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

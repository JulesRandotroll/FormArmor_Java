/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import modele.GestionSql;
import modele.PDFGenerator;
import modele.Session;

/**
 *
 * @author debor
 */
public class Controleur_GestionSession implements Initializable {

    private MainApp mainApp;

    @FXML
    private Button btn_test;
    @FXML
    private TableView<Session> tabSessions;
    @FXML
    private TableColumn<Session, String> colonneId;
    @FXML
    private TableColumn<Session, String> colonneFormation_lib;
    @FXML
    private TableColumn<Session, String> colonneDate_debut;
    @FXML
    private TableColumn<Session, String> colonneNb_places;
    @FXML
    private TableColumn<Session, String> colonneNb_inscrits;
    @FXML
    private TableColumn<Session, String> colonnePDF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         // modif 5
        // Ajoute les données de la collection de données au TableView
        
        ObservableList<Session> AllSession=GestionSql.getAllSessions();
        for(int i = 0; i< AllSession.size(); i++)
        {
            System.out.println("Controlleur session : "+AllSession.get(i));
        }
        
        tabSessions.setItems(AllSession);

        // Initialise le TableView tableSessionsAutorisees
        colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonneFormation_lib.setCellValueFactory(new PropertyValueFactory<>("libFormation"));
        colonneDate_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        colonneNb_places.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
        colonneNb_inscrits.setCellValueFactory(new PropertyValueFactory<>("nb_inscrits"));
        
       
  

        // Pour redimensionner les colonnes automatiquement
        tabSessions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void setMainApp(MainApp MainApp) {
        //System.out.println("MainApp set ?");
        this.mainApp = MainApp;
        //System.out.println("MainApp set !");
    }
    
    @FXML
    public void handle_test() throws FileNotFoundException
    {
        PDFGenerator.main();
                
                
    }
    
}

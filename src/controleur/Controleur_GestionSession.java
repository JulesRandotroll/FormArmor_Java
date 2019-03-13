/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.GestionSql;
import modele.Session;

/**
 *
 * @author debor
 */
public class Controleur_GestionSession implements Initializable {

    private MainApp mainApp;

    @FXML
    private TableView<Session> tableSession;
    @FXML
    private TableColumn<Session, String> colonneId;
    @FXML
    private TableColumn<Session, String> colonneFormation_id;
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
        // Ajoute les données de la collection de données au TableView
        tableSession.setItems(GestionSql.getAllSessions());

        // Initialise le TableView tableSessionsAutorisees
        colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonneFormation_id.setCellValueFactory(new PropertyValueFactory<>("formation_id"));
        colonneDate_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        colonneNb_places.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
        colonneNb_inscrits.setCellValueFactory(new PropertyValueFactory<>("nb_inscrits"));
        colonnePDF.setCellValueFactory(new PropertyValueFactory<>("Generer_PDF"));

        // Pour redimensionner les colonnes automatiquement
        tableSession.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void setMainApp(MainApp MainApp) {
        //System.out.println("MainApp set ?");
        this.mainApp = MainApp;
        //System.out.println("MainApp set !");
    }
}

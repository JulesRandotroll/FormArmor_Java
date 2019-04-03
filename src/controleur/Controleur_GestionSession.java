package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Formation;

import modele.GestionSql;
import modele.PDFGenerator;
import modele.Session;

public class Controleur_GestionSession implements Initializable {

    private MainApp mainApp;

    @FXML
    private Button btn_pdf;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Session> AllSession=GestionSql.getAllSessions();
        /*for(int i = 0; i< AllSession.size(); i++)
        {
            System.out.println("Controlleur session : "+AllSession.get(i));
        }*/
        
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
    public void handle_genererPDF() throws FileNotFoundException
    {
        Session SessionSelect= tabSessions.getSelectionModel().getSelectedItem();
        Formation f=GestionSql.getLaFormation(SessionSelect.getId());
        PDFGenerator.main(SessionSelect,f);
                
                
    }
    
}

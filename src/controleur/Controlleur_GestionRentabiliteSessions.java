/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.gesSession;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modele.Client_Formation;
import modele.Session_Formation;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class Controlleur_GestionRentabiliteSessions implements Initializable
{
    
    private MainApp mainApp;
    //Intensiation élements de la page
        @FXML
        private TableView<Session_Formation> tab_formation;
        @FXML
        private TableColumn<Session_Formation, String> col_nom;
        @FXML
        private TableColumn<Session_Formation, String> col_niveau;
        @FXML
        private TableColumn<Session_Formation, String> col_date;
        @FXML
        private TableView<Client_Formation> tab_clientFormation;
        @FXML
        private TableColumn<Client_Formation, String> col_client;
        @FXML
        private TableColumn<Client_Formation, String> col_taux;
        @FXML
        private TableColumn<Client_Formation, String> col_present;
        @FXML
        private Label lbl_libelle;
        @FXML
        private Label lbl_niveau;
        @FXML
        private Label lbl_type;
        @FXML
        private Label lbl_diplomante;
        @FXML
        private Label lbl_nbplaces;
        @FXML
        private Label lbl_tauxRemplissage;
        @FXML
        private Label lbl_absents;
        @FXML
        private Label lbl_duree;
        @FXML
        private Label lbl_marge;
        @FXML
        private Label lbl_nom;
        @FXML
        private Label lbl_statut;
        @FXML
        private Label txt_libelle;
        @FXML
        private Label txt_niveau;
        @FXML
        private Label txt_type;
        @FXML
        private Label txt_diplomante;
        @FXML
        private Label txt_nbplaces;
        @FXML
        private Label txt_tauxRemplissage;
        @FXML
        private Label txt_absents;
        @FXML
        private Label txt_duree;
        @FXML
        private Label txt_nom;
        @FXML
        private Label txt_statut;
        @FXML
        private Label txt_present;
        @FXML
        private RadioButton radio_present;
        @FXML
        private RadioButton radio_absent;
        @FXML
        private Button btn_modifier;
        @FXML
        private AnchorPane panel_affichSessionSel;
    //Fin INstensiation
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        remplirTableauFormations();
    } 
    
    private void remplirTableauFormations()
    {
        try
        {
            tab_formation.setItems((ObservableList<Session_Formation>)gesSession.getSessionClose());
        } 
        catch (SQLException ex)
        {
            System.out.println("ERREUR SQL changement tableau formation : "+ex.getMessage());
            Logger.getLogger(Controlleur_GestionRentabiliteSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_nom.setCellValueFactory(new PropertyValueFactory<>("libelleFormation"));
        col_niveau.setCellValueFactory(new PropertyValueFactory<>("niveauFormation"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        
        tab_formation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    @FXML
    public void handleSession()
    {
        panel_affichSessionSel.setVisible(true);
        
        txt_nom.setVisible(false);
        lbl_nom.setVisible(false);
        txt_statut.setVisible(false);
        lbl_statut.setVisible(false);
        txt_present.setVisible(false);
        radio_absent.setVisible(false);
        radio_present.setVisible(false);
        btn_modifier.setVisible(false);
        
        
        miseAJourAffichageSecondaire();
    }
    
    private void miseAJourAffichageSecondaire()
    {
        Session_Formation formationSelectionnee = (Session_Formation)tab_formation.getSelectionModel().getSelectedItem();
        System.out.println("SESSION CHOISIE : "+formationSelectionnee);
        
        //Encandré du haut : 
        lbl_libelle.setText(formationSelectionnee.getFormation().getLibelle());
        lbl_niveau.setText(formationSelectionnee.getFormation().getNiveau());
        lbl_type.setText(formationSelectionnee.getFormation().getType());
        if(formationSelectionnee.getFormation().isDiplomante())
        {
            lbl_diplomante.setText("oui");                    
        }
        else
        {
            lbl_diplomante.setText("oui");
        }
        int nbPlaces = formationSelectionnee.getNbPlace();
        lbl_nbplaces.setText(String.valueOf(nbPlaces));
        int nbInscrits = formationSelectionnee.getNbInscrits();
        System.out.println("nbInscrits : "+nbInscrits);
        int nbAbsents = formationSelectionnee.getNbAbsents();
        lbl_absents.setText(String.valueOf(nbAbsents));
        System.out.println("nbAbsents : "+nbAbsents);
        int nbPresents = nbInscrits-nbAbsents;
        System.out.println("nbPresents : "+nbPresents);
        double tauxRemplissage = nbPresents*100/nbPlaces;
        System.out.println("txRemp : "+tauxRemplissage);
        lbl_tauxRemplissage.setText(String.valueOf(tauxRemplissage));
        
        int duree = formationSelectionnee.getFormation().getDureeFormation();
        lbl_duree.setText(String.valueOf(duree));
        
        double coutRevientHoraire = formationSelectionnee.getFormation().getCoutRevient();
        
        double coutFormation = coutRevientHoraire * duree; 
        
        ArrayList<Client_Formation> lesInscrits = formationSelectionnee.getLesInscrits();
        
        double apportClient = 0;
        for(int i=0; i<lesInscrits.size();i++)
        {
            if(lesInscrits.get(i).isPresent())
            {
                double tauxHorraire = lesInscrits.get(i).getStatut().getTauxHoraire();
                apportClient = apportClient+ tauxHorraire*duree;
            }
             
        }
        double marge = apportClient - coutFormation;
        
        lbl_marge.setText(String.valueOf(marge));
        //Fin encadré du haut : 
        
        //encadré du bas : 
        tab_clientFormation.refresh();
        tab_clientFormation.getItems().clear();
        ObservableList<Client_Formation> lstDesInscrits = FXCollections.observableArrayList(lesInscrits);
        tab_clientFormation.setItems(lstDesInscrits);
        col_client.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_taux.setCellValueFactory(new PropertyValueFactory<>("tauxHoraire"));
        col_present.setCellValueFactory(new PropertyValueFactory<>("Present"));
        /*
        col_client;
        col_taux;
        col_present;
        */
        
        
        //Fin Encadré du ba
      
    }

    @FXML
    public void handleClientFormation()
    {
        txt_nom.setVisible(true);
        lbl_nom.setVisible(true);
        txt_statut.setVisible(true);
        lbl_statut.setVisible(true);
        txt_present.setVisible(true);
        radio_absent.setVisible(true);
        radio_present.setVisible(true);
        btn_modifier.setVisible(true);
        
        
        Client_Formation monClient = tab_clientFormation.getSelectionModel().getSelectedItem();
        
        lbl_nom.setText(monClient.getNom());
        lbl_statut.setText(monClient.getStatut().getType());
        if(!monClient.isPresent())
        {
            radio_absent.setSelected(true);
            radio_present.setSelected(false);
        }
        else
        {
            radio_absent.setSelected(false);
            radio_present.setSelected(true);
        }
        
    }
    
    @FXML
    public void handleNotifierAbsence()
    {
        Client_Formation monClient = tab_clientFormation.getSelectionModel().getSelectedItem();
        Session_Formation laSession = tab_formation.getSelectionModel().getSelectedItem();;
        boolean present = true;
        
        if(radio_absent.isSelected())
        {
            present = false;
        }
        
        if(present != monClient.isPresent())
        {
            //Mise à jour
            gesSession.notificationAbsence(present,monClient.getId(),laSession.getId_Session());
            monClient.setPresent(present);
            
        }
        
        
        txt_nom.setVisible(false);
        lbl_nom.setVisible(false);
        txt_statut.setVisible(false);
        lbl_statut.setVisible(false);
        txt_present.setVisible(false);
        radio_absent.setVisible(false);
        radio_present.setVisible(false);
        btn_modifier.setVisible(false);
        
            
        
        miseAJourAffichageSecondaire();
    }











    public void setMainApp(MainApp MainApp)
    {
        //System.out.println("MainApp set ?");
        this.mainApp = MainApp;
        //System.out.println("MainApp set !");
    }
}

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.Session;

/**
 * FXML Controller class
 *
 * @author jules
 */
public class Controlleur_GestionRentabiliteSessions implements Initializable
{
    @FXML
    private TableView<Session> tab_formation;
    @FXML
    private TableColumn<Session, String> col_nom;
    @FXML
    private TableColumn<Session, String> col_niveau;
    @FXML
    private TableColumn<Session, String> col_date;
    @FXML
    private TableView<Session> tab_cientFormation;
    @FXML
    private TableColumn<Session, String> col_client;
    @FXML
    private TableColumn<Session, String> col_taux;
    @FXML
    private TableColumn<Session, String> col_present;
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
    private RadioButton radio_present;
    @FXML
    private RadioButton radio_absent;
    @FXML
    private Button btn_modifier;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}

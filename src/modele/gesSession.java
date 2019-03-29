/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.GestionBdd;

 // modif 12
public class gesSession
{
    
    public static ObservableList getSessionClose() throws SQLException
    {
        Connection conn;
        Statement stmt;
        ObservableList<Session_Formation> lstSession = FXCollections.observableArrayList();
        ArrayList<Client_Formation> lesInscrits;
        
        stmt = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
        
        String req = "Select * from formation f, session_formation s Where s.formation_id = f.id AND close=1 order by date_debut DESC";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while (rs.next())
            {
                int idSession = rs.getInt("s.id");
                int nbInscrits = rs.getInt("nb_inscrits");
                int nbPlaces = rs.getInt("nb_places");
                boolean close = rs.getBoolean("close");
                String dateDebut = rs.getString("date_debut");
                
                
                int idFormation = rs.getInt("formation_id");
                String libelleFormation = rs.getString("libelle");
                String niveau = rs.getString("niveau");
                String type = rs.getString("type_form");
                String description = rs.getString("description");
                boolean diplomante = rs.getBoolean("diplomante");
                int duree = rs.getInt("duree");
                double coutRevient =rs.getDouble("coutrevient");
                lesInscrits = new ArrayList<Client_Formation>();
                Statement stmt2 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
                String req2 = "SELECT * FROM client c, inscription i, statut s WHERE c.`id` = i.client_id AND s.id = c.statut_id AND session_formation_id = "+idSession;
                ResultSet rs2 = GestionBdd.envoiRequeteLMD(stmt2,req2);
                while(rs2.next())
                {
                    int id, nbhcpta, nbhbur, id_statut;
                    String nom, password, adresse, cp, ville, email, dateInscription, type_statut;
                    Client_Formation c1;
                    Statut s;
                    boolean present;
                    double tauxHoraire;
                    
                    id = rs2.getInt("c.id");
                    nbhcpta = rs2.getInt("nbhcpta");
                    nbhbur = rs2.getInt("nbhbur");
                    id_statut = rs2.getInt("statut_id");
                    nom = rs2.getString("nom");
                    password = rs2.getString("password");
                    adresse = rs2.getString("adresse");
                    cp = rs2.getString("cp");
                    ville = rs2.getString("ville");
                    email = rs2.getString("email");
                    dateInscription = rs2.getString("date_inscription");
                    type_statut = rs2.getString("s.type");
                    tauxHoraire = rs2.getDouble("taux_horaire");
                    present = rs2.getBoolean("present");
                    
                    s= new Statut(id_statut, tauxHoraire, type_statut);
                    
                    c1 = new Client_Formation(id, nbhcpta, nbhbur, nom, password, adresse, cp, ville, email, dateInscription, s,present);
                    
                    lesInscrits.add(c1);
                }
                
                Formation uneFormation = new Formation(idFormation,duree,libelleFormation,niveau,type,description,diplomante,coutRevient);
                Session_Formation uneSession = new Session_Formation(idSession, dateDebut, nbPlaces, nbInscrits, close, uneFormation,lesInscrits);
                lstSession.add(uneSession);
   
            }
        return lstSession;
    }
    
    
    
    public static void notificationAbsence(boolean present, int idClient, int idSession)
    {
        Connection conn;
        Statement stmt;
        
        stmt = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
    
        
        String req = "UPDATE `inscription` SET `present`= "+String.valueOf(present)+" WHERE client_id = "+String.valueOf(idClient)+" AND session_formation_id = "+idSession;
        //UPDATE inscription SET present = true WHERE client_id = 3 AND session_formation_id = 6
        
        
        ResultSet nb = GestionBdd.envoiRequeteLMD(stmt,req);
        System.out.println("\nkeskécé ? "+nb);
        int nb2 = GestionBdd.envoiRequeteLID(stmt, req);
        System.out.println("keskécé ? "+nb2);
        System.out.println("Requete : "+req+"\n");
        
        
    
    }
    /*public static ObservableList getSessionClose() throws SQLException
    {
        Connection conn;
        Statement stmt;
        ObservableList lstSession = FXCollections.observableArrayList();
        
        stmt = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
        
        String req = "Select * from formation f, session_formation s Where s.formation_id = f.id AND close=1";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while (rs.next())
            {
                double tauxRemplissage=0;
                int nbPresent = rs.getInt("nb_inscrits");
                int nbPlaces = rs.getInt("nb_places");
                
                tauxRemplissage = (nbPresent / nbPlaces)*100;
                
                
                int nbAbs = nbPlaces - nbPresent;
                double marge = 0 ;
                
                String[] ligneTableau = {rs.getString("libelle"),rs.getString("date_debut"),Double.toString(tauxRemplissage),Integer.toString(nbAbs),Double.toHexString(marge)};
                lstSession.add(ligneTableau);
            }
        
        
        return lstSession;
    }*/
}

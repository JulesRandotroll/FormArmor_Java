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
        ObservableList lstSession = FXCollections.observableArrayList();
        
        stmt = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "formarmor","localhost", "root","");
        
        String req = "Select * from formation f, session_formation s Where s.formation_id = f.id AND close=1";
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
                
                Formation uneFormation = new Formation(idFormation,duree,libelleFormation,niveau,type,description,diplomante,coutRevient);
                Session_Formation uneSession = new Session_Formation(idSession, dateDebut, nbPlaces, nbInscrits, close, uneFormation);
                lstSession.add(uneSession);
   
            }
        
        
        return lstSession;
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

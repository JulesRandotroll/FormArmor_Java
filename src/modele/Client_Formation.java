/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author jules
 */
public class Client_Formation
{
    private int id, nbhcpta, nbhbur;
    private String nom, password, adresse, cp, ville, email, dateInscription;
    Statut statut;
    boolean present;

    public Client_Formation()
    {
    }

    public Client_Formation(int id, int nbhcpta, int nbhbur, String nom, String password, String adresse, String cp, String ville, String email, String dateInscription, boolean present)
    {
        this.id = id;
        this.nbhcpta = nbhcpta;
        this.nbhbur = nbhbur;
        this.nom = nom;
        this.password = password;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.email = email;
        this.dateInscription = dateInscription;
        this.present = present;
    }

    public Client_Formation(int id, int nbhcpta, int nbhbur, String nom, String password, String adresse, String cp, String ville, String email, String dateInscription, Statut statut, boolean present)
    {
        this.id = id;
        this.nbhcpta = nbhcpta;
        this.nbhbur = nbhbur;
        this.nom = nom;
        this.password = password;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.email = email;
        this.dateInscription = dateInscription;
        this.statut = statut;
        this.present = present;
    }

    public boolean isPresent()
    {
        return present;
    }

    public void setPresent(boolean present)
    {
        this.present = present;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getNbhcpta()
    {
        return nbhcpta;
    }

    public void setNbhcpta(int nbhcpta)
    {
        this.nbhcpta = nbhcpta;
    }

    public int getNbhbur()
    {
        return nbhbur;
    }

    public void setNbhbur(int nbhbur)
    {
        this.nbhbur = nbhbur;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getCp()
    {
        return cp;
    }

    public void setCp(String cp)
    {
        this.cp = cp;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDateInscription()
    {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription)
    {
        this.dateInscription = dateInscription;
    }

    public Statut getStatut()
    {
        return statut;
    }

    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }
    
    public String getPresent()
    {
        if(present)
        {
            return "oui";
        }
        return "non";
    }
    
    //Statut
    
    public double getTauxHoraire()
    {
        return statut.getTauxHoraire();
    }
    
    //fin Statut

    @Override
    public String toString()
    {
        return nom;
    }

    
    
    
    
}

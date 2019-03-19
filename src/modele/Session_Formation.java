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
public class Session_Formation
{
    int id_Session;
    String dateDebut;
    int nbPlace, nbInscrits;
    boolean close;
    Formation formation;

    public Session_Formation()
    {
    }

    public Session_Formation(int id_Session, String dateDebut, int nbPlace, int nbInscrits, boolean close)
    {
        this.id_Session = id_Session;
        this.dateDebut = dateDebut;
        this.nbPlace = nbPlace;
        this.nbInscrits = nbInscrits;
        this.close = close;
    }

    public Session_Formation(int id_Session, String dateDebut, int nbPlace, int nbInscrits, boolean close, Formation formation)
    {
        this.id_Session = id_Session;
        this.dateDebut = dateDebut;
        this.nbPlace = nbPlace;
        this.nbInscrits = nbInscrits;
        this.close = close;
        this.formation = formation;
    }

    public int getId_Session()
    {
        return id_Session;
    }

    public void setId_Session(int id_Session)
    {
        this.id_Session = id_Session;
    }

    public String getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public int getNbPlace()
    {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace)
    {
        this.nbPlace = nbPlace;
    }

    public int getNbInscrits()
    {
        return nbInscrits;
    }

    public void setNbInscrits(int nbInscrits)
    {
        this.nbInscrits = nbInscrits;
    }

    public boolean isClose()
    {
        return close;
    }

    public void setClose(boolean close)
    {
        this.close = close;
    }

    public Formation getFormation()
    {
        return formation;
    }

    public void setFormation(Formation formation)
    {
        this.formation = formation;
    }

    @Override
    public String toString()
    {
        return formation.toString();
    }
    
    
    
}

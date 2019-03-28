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
public class Statut
{
    int id;
    double tauxHoraire;
    String type;

    public Statut(int id, double tauxHoraire, String type)
    {
        this.id = id;
        this.tauxHoraire = tauxHoraire;
        this.type = type;
    }

    public Statut()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getTauxHoraire()
    {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire)
    {
        this.tauxHoraire = tauxHoraire;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }
    
    
}

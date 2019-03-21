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
public class Formation
{
    int idFormation, dureeFormation;
    String libelle, niveau, type, description;
    boolean diplomante;
    double coutRevient;

    public Formation()
    {
    }

    public Formation(int idFormation, int dureeFormation, String libelle, String niveau, String type, String description, boolean diplomante, double coutRevient)
    {
        this.idFormation = idFormation;
        this.dureeFormation = dureeFormation;
        this.libelle = libelle;
        this.niveau = niveau;
        this.type = type;
        this.description = description;
        this.diplomante = diplomante;
        this.coutRevient = coutRevient;
    }

    public int getIdFormation()
    {
        return idFormation;
    }

    public void setIdFormation(int idFormation)
    {
        this.idFormation = idFormation;
    }

    public int getDureeFormation()
    {
        return dureeFormation;
    }

    public void setDureeFormation(int dureeFormation)
    {
        this.dureeFormation = dureeFormation;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public String getNiveau()
    {
        return niveau;
    }

    public void setNiveau(String niveau)
    {
        this.niveau = niveau;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isDiplomante()
    {
        return diplomante;
    }

    public void setDiplomante(boolean diplomante)
    {
        this.diplomante = diplomante;
    }

    public double getCoutRevient()
    {
        return coutRevient;
    }

    public void setCoutRevient(double coutRevient)
    {
        this.coutRevient = coutRevient;
    }

    @Override
    public String toString()
    {
        return libelle+" "+niveau; 
                 
    }

    
    
    
    
}

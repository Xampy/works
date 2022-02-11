/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaeclipselink.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DREE
 */
@Entity
@Table
public class Intervention {
    
    @EmbeddedId
    private InterventionPK id;

    public Intervention() {
        this.id = new InterventionPK();
    }
       
    @ManyToOne
    private Cours cours;
    
    @ManyToOne
    private Departement departement;
    
    @ManyToOne
    private Professeur professeur;
    
    

    public Intervention(Cours cours, Departement departement, Professeur professeur) {
        this.id = new InterventionPK();
        
        this.id.setCoursId(cours.getId());
        this.id.setDepartementId(departement.getId());
        this.id.setProfesseurId(professeur.getId());
        
        this.cours = cours;
        this.departement = departement;
        this.professeur = professeur;
       
    }

    public InterventionPK getId() {
        return id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaeclipselink.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DREE
 */
@Entity
@Table(name = "etudiant")
public class Etudiant extends Personne {

    private String adresse;
    private String telephone;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "DEPARTEMENT_ID") //Retaion unidirectionnelle
    private Departement departement;
    
    //Créer un étudiant => créer ces cours se fait avec les cascades
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "INSCRIPTION_COURS",
        joinColumns = @JoinColumn(name = "etudiant_id"), //The current entity object
        inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Cours> cours;

    public Etudiant() {
        this.cours = new ArrayList<>();
    }
    
    /**
     * 
     * @param nom
     * @param prenoms
     * @param email
     * @param adresse
     * @param telephone
     * @param departement 
     */
    public Etudiant(String nom, String prenoms, String email, String adresse, 
            String telephone, Departement departement) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.departement = departement;
        
        this.cours = new ArrayList<>();
    }
    
    

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
    
    

}

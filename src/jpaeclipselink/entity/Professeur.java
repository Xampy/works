/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaeclipselink.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 *
 * @author DREE
 */
@Entity
@Table(name="professeur")
public class Professeur extends Personne {
    private String grade;
    
    @ManyToMany(mappedBy = "professeurs", cascade = CascadeType.PERSIST)
    private List<Departement> departements;
    

    public Professeur() {
        this.departements = new ArrayList<>();
    }

    public Professeur(String nom, String prenoms, String email, String grade) {
        this.setNom(nom);
        this.setPrenoms(prenoms);
        this.setEmail(email);
        
        this.grade = grade;
        this.departements = new ArrayList<>();
    }
    
    

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
    
    
    
}

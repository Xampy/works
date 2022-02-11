/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JpaTest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpaeclipselink.entity.Cours;
import jpaeclipselink.entity.Departement;
import jpaeclipselink.entity.Etudiant;
import jpaeclipselink.entity.Intervention;
import jpaeclipselink.entity.Professeur;

/**
 *
 * @author DREE
 */
public class JpaApp {
    
    static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JpaEclipseLinkPU");
    static EntityManager entityManager = managerFactory.createEntityManager();
    
    public static void main(String[] args) {

        EntityTransaction transaction = entityManager.getTransaction();

        Etudiant[] etudiants = {
            new Etudiant(
            "Nom Etudiant 1", "Prenoms Etudiant 1",
            "Adresse 1", "email1@gmail.com", "Numeroro 1", null),
            new Etudiant(
            "Nom Etudiant 2", "Prenoms Etudiant 2",
            "Adresse 2", "email1@gmail.com", "Numeroro 2", null),
            new Etudiant(
            "Nom Etudiant 3", "Prenoms Etudiant 3",
            "Adresse 3", "email3@gmail.com", "Numeroro 3", null),
            new Etudiant(
            "Nom Etudiant 4", "Prenoms Etudiant 4",
            "Adresse 4", "email4@gmail.com", "Numeroro 4", null)
        };

        Departement departementBiologie = new Departement();
        departementBiologie.setNom("Biologie");
        departementBiologie.setAdresseWeb("ipnet_biologie.com");

        Departement departementInformatique = new Departement();
        departementInformatique.setNom("Informatique");
        departementInformatique.setAdresseWeb("ipnet_biologie.com");

        Professeur professeurBiologie = new Professeur(
                "Nom Prof Biologie", "Prenoms Brof Biologie",
                "Email Prof Biologie", "Doctorat");
        Professeur professeurMathematique = new Professeur(
                "MAGNANI", "Esso",
                "Email Prof Math", "Doctorat");
        Professeur professeurInformatique = new Professeur(
                "Nom Prof Informatique", "Prenoms Brof Informatique",
                "Email Prof Informatique", "Doctorat");
        
        ArrayList<Departement> profBioDep = new ArrayList<>();
        profBioDep.add(departementBiologie);
        professeurBiologie.setDepartements(profBioDep);
        
        professeurInformatique.getDepartements().add(departementInformatique);
        professeurMathematique.getDepartements().add(departementInformatique);
        professeurMathematique.getDepartements().add(departementBiologie);

        Cours coursBiologieMoleculaire = new Cours("Biologie Moléculaire");
        Cours coursPoo = new Cours("Programmation Orientée Objet");
        Cours coursAnalyseNumerique = new Cours("Analyse numérique");

        try {
            transaction.begin();

            etudiants[0].setDepartement(departementInformatique);
            etudiants[3].setDepartement(departementInformatique);

            etudiants[1].setDepartement(departementBiologie);
            etudiants[2].setDepartement(departementBiologie);

            etudiants[0].getCours().add(coursPoo);
            etudiants[0].getCours().add(coursAnalyseNumerique);
            etudiants[3].getCours().add(coursPoo);
            etudiants[3].getCours().add(coursAnalyseNumerique);

            etudiants[1].getCours().add(coursBiologieMoleculaire);
            etudiants[1].getCours().add(coursAnalyseNumerique);
            etudiants[2].getCours().add(coursBiologieMoleculaire);
            etudiants[2].getCours().add(coursAnalyseNumerique);

            for (Etudiant etudiant : etudiants) {
                entityManager.persist(etudiant);
            }

            entityManager.persist(professeurInformatique);
            entityManager.persist(professeurBiologie);
            entityManager.persist(professeurMathematique); 
            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
        
        try {
            transaction.begin();
            
            Intervention[] interventions = {
                new Intervention(coursBiologieMoleculaire, departementBiologie, professeurBiologie),
                new Intervention(coursPoo, departementInformatique, professeurInformatique),
                new Intervention(coursAnalyseNumerique, departementInformatique, professeurMathematique),
                new Intervention(coursAnalyseNumerique, departementBiologie, professeurMathematique)
            };
            
            for (Intervention intervention: interventions){
                entityManager.persist(intervention);
            }
            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            
        }
        
        getNames();
        getFields();
        getBiologieEtudiant();
        getEtudiantCoursBiologieAnimale();
        getProfesseursDepartementInformatique();
        getProfesseursCousAlgebre();
        
        entityManager.close();
        managerFactory.close();
    }
    
    
    public static void getNames(){
        Query q = entityManager.createQuery("SELECT e.nom FROM Etudiant e");
        List<String> noms = q.getResultList();
        
        noms.forEach( n -> System.out.println(n));
    }
    
    public static void getFields(){
        Query q = entityManager.createQuery("SELECT e.nom, e.prenoms FROM Etudiant e");
        List<Object[]> minEtudiants = (List<Object[]>) q.getResultList();
        
        minEtudiants.forEach( e -> System.out.println(e[0] + " - " + e[1]));
        
    }
    
    /**
     * Les étudiants dans le département de biologie
     */
    public static void getBiologieEtudiant(){
        Query q = entityManager.createQuery(
                "SELECT e " +
                "FROM Etudiant e " +
                "WHERE e.departement.nom LIKE 'Biologie'");
        
        List<Etudiant> etudiants = q.getResultList();
        System.out.println("\nEtuidants en Biologie\n");
        etudiants.forEach( e -> System.out.println(e.getNom()));
    }
    
    public static void getEtudiantCoursBiologieAnimale(){
        Query q = entityManager.createQuery(
                "SELECT e " +
                "FROM Etudiant e " +
                "INNER JOIN e.cours c " +
                "WHERE c.titre = 'Biologie Moléculaire' ");
        
        List<Etudiant> etudiants = q.getResultList();
        System.out.println("\nEtuidants en Biologie Moléculaire\n");
        etudiants.forEach( e -> System.out.println(e.getNom()));
    }
    
    public static void getProfesseursDepartementInformatique(){
        Query q = entityManager.createQuery(
            "SELECT p " + 
            "FROM Professeur p " +
            "INNER JOIN p.departements d " +
            "WHERE d.nom LIKE 'Informatique'");
        
        List<Professeur> professeurs = (List<Professeur>) q.getResultList();
        System.out.println("\nProfesseurs en Departement Informatique\n");
        
        professeurs.forEach( p -> System.out.println(p.getNom()));
    }
    
    public static void getProfesseursCousAlgebre(){
        Query q = entityManager.createQuery(
           "SELECT i.professeur " +
           "FROM Intervention i " +
           "WHERE i.cours.titre = 'Analyse numérique' "
        );
        
        List<Professeur> professeurs = (List<Professeur>) q.getResultList();
        System.out.println("\nProfesseurs en Departement Informatique\n");
        
        professeurs.forEach( p -> System.out.println(p.getNom()));
                
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaeclipselink.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author DREE
 */
@Embeddable
public class InterventionPK {
    private Long coursId;
    private Long departementId;
    private Long professeurId;
    

    public InterventionPK() {
    }
    
    

    public InterventionPK(Long coursId, Long departementId, Long professeurId) {
        this.coursId = coursId;
        this.departementId = departementId;
        this.professeurId = professeurId;
    }

    public Long getCoursId() {
        return coursId;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public Long getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Long departementId) {
        this.departementId = departementId;
    }

    public Long getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Long professeurId) {
        this.professeurId = professeurId;
    }
    
    
    
    
    
    
}

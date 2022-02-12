/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author XAMPY
 */
@Entity
@Table(name = "DEMANDE_CREDIT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeCredit implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private Double montant;
	
	/**
	 * La durée exprimée en années
	 */
	private Integer duree;
	
	private Double taux;
	
	private Boolean approbe;
	
	private Date dateDemande;
	
	private Date dateEffective;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Client client;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof DemandeCredit)) {
			return false;
		}
		DemandeCredit other = (DemandeCredit) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.kayiyaomaxime.demandecreditbanque.entity.DemandeCredit[ id=" + id + " ]";
	}

}

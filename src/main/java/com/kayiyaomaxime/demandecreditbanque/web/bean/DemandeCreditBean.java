/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.web.bean;


import com.kayiyaomaxime.demandecreditbanque.entity.Client;
import com.kayiyaomaxime.demandecreditbanque.entity.DemandeCredit;
import com.kayiyaomaxime.demandecreditbanque.service.ClientServiceInterface;
import com.kayiyaomaxime.demandecreditbanque.service.DemandeCreditServiceInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author XAMPY
 */
@Named(value = "demandeCreditBean")
@RequestScoped
public class DemandeCreditBean implements Serializable{
	
	private DemandeCredit demandeCredit;
	private String selectedClientId;
	private Date choosedDate;
	
	@EJB
	private ClientServiceInterface clientService;
	
	@EJB
	private DemandeCreditServiceInterface demandeCreditService;
	
	private List<Client> clients;
		
	public DemandeCreditBean() {
		this.demandeCredit = new DemandeCredit();
	}
	
	/**
	 * To redirect just put returnthe string form of the 
	 * @return 
	 */
	public void saveDemande(){
		System.out.println(this.demandeCredit);
		System.out.println("com.kayiyaomaxime.demandecreditbanque.web.bean.DemandeCreditBean.saveDemande()");
		
		Client client = this.clientService.getById(
			Long.parseLong(this.selectedClientId));
		
		//System.out.println("Departement " + this.etudiant.getDepartement().getNom());
		this.demandeCredit.setClient(client);;
		this.demandeCredit.setApprobe(Boolean.FALSE);
		this.demandeCredit.setDateDemande(new java.sql.Date(this.choosedDate.getTime()));
		this.demandeCredit.setDateEffective(null);
		this.demandeCreditService.create(this.demandeCredit);
		
		this.demandeCredit = new DemandeCredit();
		this.choosedDate = null;
		this.selectedClientId = null;
	}
	
	public void delete(Long id){
		DemandeCredit demande = this.demandeCreditService.getById(id);
		if (demande != null){
			this.demandeCreditService.delete(id);
		}
	}
	
	public void acceptDemane(Long id){
		DemandeCredit demande = this.demandeCreditService.getById(id);
		if (demande != null){
			demande.setApprobe(true);
			demande.setDateEffective(new java.sql.Date( (new Date()).getTime() ));
			
			this.demandeCreditService.update(demande);
		}
	}
	
	public ArrayList<SelectItem> getClientSelectOptions(){
		ArrayList<SelectItem> options = new ArrayList<>();
		options.add(new SelectItem(null, "Choisissez..."));
		List<Client> clients = this.clientService.getAll();
			
		for (Client d: clients){
			options.add(new SelectItem(d.getId().toString(), d.getNom() + " " + d.getPrenom()));
		}
		return options;
	}

	

	public List<DemandeCredit> getDemandesCreditList() {
		return this.demandeCreditService.getAll();
	}

	public DemandeCredit getDemandeCredit() {
		return demandeCredit;
	}

	public void setDemandeCredit(DemandeCredit demandeCredit) {
		this.demandeCredit = demandeCredit;
	}

	public String getSelectedClientId() {
		return selectedClientId;
	}

	public void setSelectedClientId(String selectedClientId) {
		this.selectedClientId = selectedClientId;
	}

	public Date getChoosedDate() {
		return choosedDate;
	}

	public void setChoosedDate(Date choosedDate) {
		this.choosedDate = choosedDate;
	}
	
	
	
	
	
	

}
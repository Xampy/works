/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.web.bean;

import com.kayiyaomaxime.demandecreditbanque.entity.Client;
import com.kayiyaomaxime.demandecreditbanque.service.ClientServiceInterface;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author XAMPY
 */
@Named(value = "clientBean")
@RequestScoped
public class ClientBean {

	@EJB
	private ClientServiceInterface  clientService;

	private Client client;
	
	private Long clientId = -1L;

	public ClientBean() {
		this.client = new Client();
	}

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext()
			.getRequest();
		System.out.println("Client Id " + request.getParameter("clientId"));

		if (request.getParameter("clientId") != null) {
			this.clientId = Long.parseLong(request.getParameter("clientId"));
			this.client = this.clientService.getById(this.clientId);
		}
	}

	public String  saveClient() {
		if (this.clientId == -1) {
			this.clientService.create(client);
		} else {
			this.clientService.update(client);
		}
		
		return "";
	}

	public String delete(Long id) {
		System.out.println("Supress " + id);
		this.clientService.delete(id);
		return "";
	}

	public List<Client> getClientList() {
		return this.clientService.getAll();
	}

	public Client getClient() {
		return this.client;
	}

}

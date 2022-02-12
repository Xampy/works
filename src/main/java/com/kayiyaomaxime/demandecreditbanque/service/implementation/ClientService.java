/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kayiyaomaxime.demandecreditbanque.service.implementation;

import com.kayiyaomaxime.demandecreditbanque.database.dao.ClientDaoInterface;
import com.kayiyaomaxime.demandecreditbanque.entity.Client;
import com.kayiyaomaxime.demandecreditbanque.service.ClientServiceInterface;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author XAMPY
 */
@Stateless
public class ClientService implements ClientServiceInterface {
	
	@EJB
	private ClientDaoInterface clientDao;

	@Override
	public Client create(Client entity) {
		try {
			this.clientDao.create(entity);
			return entity;
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
		
		return null;		
	}

	@Override
	public Client update(Client entity) {
		try {
			this.clientDao.update(entity);
			return entity;
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			Client client = this.clientDao.find(id);
			if (client != null)
				this.clientDao.delete(client);
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
	}

	@Override
	public List<Client> getAll() {
		return this.clientDao.findAll();
	}

	@Override
	public Client getById(Long id) {
		return this.clientDao.find(id);
	}

}

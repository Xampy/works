/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kayiyaomaxime.demandecreditbanque.service.implementation;

import com.kayiyaomaxime.demandecreditbanque.database.dao.DemandeCreditDaoInterface;
import com.kayiyaomaxime.demandecreditbanque.entity.DemandeCredit;
import com.kayiyaomaxime.demandecreditbanque.service.DemandeCreditServiceInterface;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author XAMPY
 */
@Stateless
public class DemandeCreditService implements DemandeCreditServiceInterface {
	
	@EJB
	private DemandeCreditDaoInterface demandeCreditDao;

	@Override
	public DemandeCredit create(DemandeCredit entity) {
		try {
			this.demandeCreditDao.create(entity);
			return entity;
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
		
		return null;		
	}

	@Override
	public DemandeCredit update(DemandeCredit entity) {
		try {
			this.demandeCreditDao.update(entity);
			return entity;
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			DemandeCredit dc = this.demandeCreditDao.find(id);
			if (dc != null)
				this.demandeCreditDao.delete(dc);
		} catch (Exception e) {
			System.err.println("Error occured ->  " + e.getMessage() );
		}
	}

	@Override
	public List<DemandeCredit> getAll() {
		return this.demandeCreditDao.findAll();
	}

	@Override
	public DemandeCredit getById(Long id) {
		return this.demandeCreditDao.find(id);
	}

}

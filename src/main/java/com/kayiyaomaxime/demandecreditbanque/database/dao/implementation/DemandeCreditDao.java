/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kayiyaomaxime.demandecreditbanque.database.dao.implementation;

import com.kayiyaomaxime.demandecreditbanque.database.dao.AbstractDao;
import com.kayiyaomaxime.demandecreditbanque.database.dao.ClientDaoInterface;
import com.kayiyaomaxime.demandecreditbanque.database.dao.DemandeCreditDaoInterface;
import com.kayiyaomaxime.demandecreditbanque.entity.Client;
import com.kayiyaomaxime.demandecreditbanque.entity.DemandeCredit;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author XAMPY
 */
@Stateless
public class DemandeCreditDao extends AbstractDao<DemandeCredit, Long> implements DemandeCreditDaoInterface {

	public DemandeCreditDao() {
		super(DemandeCredit.class);
	}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kayiyaomaxime.demandecreditbanque.database.dao.implementation;

import com.kayiyaomaxime.demandecreditbanque.database.dao.AbstractDao;
import com.kayiyaomaxime.demandecreditbanque.database.dao.ClientDaoInterface;
import com.kayiyaomaxime.demandecreditbanque.entity.Client;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author XAMPY
 */
@Stateless
public class ClientDao extends AbstractDao<Client, Long> implements ClientDaoInterface {

	public ClientDao() {
		super(Client.class);
	}

}

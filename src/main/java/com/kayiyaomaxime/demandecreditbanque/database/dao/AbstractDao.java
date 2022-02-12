/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.database.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author X
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractDao<T extends Object, PK extends Serializable> {

	@PersistenceContext(name = "webPU")
	protected EntityManager entityManager;

	protected Class<T> clazz;

	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void create(T entity) {
		this.entityManager.persist(entity);
		this.entityManager.flush();
	}

	public T update(T entity) {
		return this.entityManager.merge(entity);
	}

	public void delete(T entity) {
		this.entityManager.remove(entity);
	}

	public T find(PK id) {
		return this.entityManager.find(this.clazz, id);
	}

	public List<T> findAll() {
		String query = "SELECT t FROM " + this.clazz.getSimpleName() + " t";
		List<T> results = this.entityManager.createQuery(query).getResultList();
		return results;
	}

}

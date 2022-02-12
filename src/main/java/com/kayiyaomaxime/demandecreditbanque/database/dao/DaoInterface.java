/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.database.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author XAMPY
 */
public interface DaoInterface<T extends Object, PK extends Serializable> {

	public void create(T entity);

	public T update(T entity);

	public void delete(T entity);

	public T find(PK id);

	public List<T> findAll();
}

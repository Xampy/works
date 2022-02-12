/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kayiyaomaxime.demandecreditbanque.service;

import java.util.List;

/**
 *
 * @author XAMPY
 */
public interface ServiceInterface<E> {

	/**
	 * Créer
	 *
	 * @param entity
	 * @return
	 */
	public E create(E entity);

	/**
	 * Mettre à jour
	 *
	 * @param entity
	 * @return
	 */
	public E update(E entity);

	/**
	 * Supprimer
	 *
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * Récupérer la liste
	 *
	 * @return
	 */
	public List<E> getAll();

	/**
	 * Récupérer par l'id
	 *
	 * @param id de l'entité à trouver
	 * @return
	 */
	public E getById(Long id);

}

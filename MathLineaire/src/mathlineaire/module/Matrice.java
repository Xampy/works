/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mathlineaire.module;

import java.util.Arrays;

/**
 *
 * @author XAMPY
 */
public class Matrice {

	/**
	 * Le nombre de ligne
	 */
	private int r;

	/**
	 * Le nombre de colonne
	 */
	private int c;

	private double[][] matrice;
	
	/**
	 * Constructuer. Création du tableau de la matrice
	 * 
	 * @param r un entier spécifiant le nombre de ligne
	 * @param c un entier spécifiant le nombre de colonne 
	 */
	public Matrice(int r, int c) {
		this.r = r;
		this.c = c;
		
		this.matrice = new double[r][c];
		
		//On inititalise pour éviter n'imprt quoi au premier accès
		for (int i =0; i < r; i++)
			Arrays.fill(this.matrice[i], 0);
	}
	
	/**
	 * Définir un élément de la matrice à l’intercession de la ligne row et de la colonne col;
	 * 
	 * @param row un entier commençant par 0 indiquant la ligne sur laquelle on veut faire la définition
	 * @param col un entier commençant par 0 indiquant la colonne sur laquelle on veut faire la définition
	 * @param value la valeur à mettre à l'intersection
	 * @throws java.lang.Exception si l'index de la ligne ou de la colonne fournit sot de l'intervalle définit
	 */
	public void setElementAt(int row, int col, double value) throws Exception{
		final boolean estValid = (row >= 0 && row < this.getR()) && (col >= 0 && col < this.getC());
		if (estValid){
			this.matrice[row][col] = value;
		}else {
			throw new Exception("Valeurs hors intervalle");
		}
	}
	
	/**
	 * Obtenir un élément de la matrice à l’intercession de la ligne row et de la colonne col;
	 * 
	 * @param row un entier commençant par 0 indiquant la ligne sur laquelle on veut faire la définition
	 * @param col un entier commençant par 0 indiquant la colonne sur laquelle on veut faire la définition
	 * @return un double la valeur trouvée à l'intersection
	 * @throws java.lang.Exception si l'index de la ligne ou de la colonne fournit sot de l'intervalle définit
	 */
	public double getElementAt(int row, int col) throws Exception{
		final boolean estValid = (row >= 0 && row < this.getR()) && (col >= 0 && col < this.getC());
		if (estValid){
			return this.matrice[row][col];
		}else {
			throw new Exception("Valeurs hors intervalle");
		}
	}
	
	/**
	 * Otenir la dimension de la matrice
	 * @return une chaine de la forme (<nombre de ligne>, <nombre de colonne>)
	 */
	public String dim(){
		return "(" + this.r + ", " + this.c + ")";
	}
	
	/**
	 * Ajouter une matrice à la matrice courante, et renvoyer une matrice.
	 * @param obj la matrice à ajouter à la matrice courante
	 * @return
	 * @throws Exception 
	 */
	public Matrice add(Matrice obj) throws Exception{
		final boolean estValid = (obj.getR() == this.getR()) && (obj.getC() == this.getC());
		if (!estValid){
			throw new Exception("Les deux matrices n'ont pas la même dimension");
		}
		
		Matrice result = new Matrice(this.getR(), this.getC());
		for (int i=0; i < result.getR(); i++)
			for (int j=0; j < result.getC(); j++){
				final double value = this.getElementAt(i, j) + obj.getElementAt(i,  j);
				result.setElementAt(i, j, value);
			}
		return result;
	}
	
	/**
	 * Multiplier une matrice à la matrice courante, et renvoyer une matrice.
	 * @param obj la matrice à ajouter à la matrice courante
	 * @return
	 * @throws Exception 
	 */
	public Matrice mutiplier(Matrice obj) throws Exception{
		final boolean estValid = (obj.getR() == this.getC());
		if (!estValid){
			throw new Exception("Les deux matrices ne concordent pas pour une multilication");
		}
		
		Matrice result = new Matrice(this.getR(), obj.getC());
		for (int i=0; i < result.getR(); i++)
			for (int j=0; j < obj.getC(); j++){
				double value = 0;
				for (int k=0; k < obj.getR(); k ++){
					value += this.getElementAt(i, k) * obj.getElementAt(k, j);
				}
				result.setElementAt(i, j, value);
			}
		return result;
	}
	
	/**
	 * Afficher la matrice sous forme de tableai.
	 */
	public void show(){
		for (int i =0; i < r; i++){
			for (int j=0; j < c; j ++){
				System.out.print(this.matrice[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public double[][] getMatrice() {
		return matrice;
	}
	
	
	
}

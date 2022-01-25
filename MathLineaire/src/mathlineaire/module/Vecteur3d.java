/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mathlineaire.module;

/**
 *
 * @author XAMPY
 */
public class Vecteur3d {
	/**
	 * Première comosante
	 */
	private double x;
	
	/**
	 * Deuxième composante
	 */
	private double y;
	
	/**
	 * Troisième componante
	 */
	private double z;

	/**
	 * Construceur.
	 * 
	 * @param x un double pour la première composante
	 * @param y un double pour la deuxième composante
	 * @param z un double pour la troisième composante
	 */
	public Vecteur3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Affiche le vecteur sous la forme (x, y, z).
	 */
	public void show(){
		System.out.println("(" + x + ", " + y + ", " +z +")");
	}
	
	/**
	 * Calcule la norme du vectur et le retourne
	 * @return un double représentant la norme du vecteur
	 */
	public double norme(){
		return  Math.sqrt( x*x + y*y + z*z);
	}
	
	/**
	 * Fournit la somme de deux vecteurs et retourne un vecteur
	 * @param v1 le premier vecteur
	 * @param v2 le deuxième vecteur
	 * @return un vecteur qui est égal à la somme des deux veecteurs
	 */
	public static Vecteur3d add(Vecteur3d v1, Vecteur3d v2){
		return new Vecteur3d(
			v1.getX() + v1.getX(), 
			v1.getY() + v2.getY(), 
			v1.getZ() + v2.getZ());
	} 
	
	/**
	 * Calcule le scalire de deux vecteurs et le retourne
	 * @param v1 le premier vecteur
	 * @param v2 le deuxième vecteur
	 * @return un double
	 */
	public double dot(Vecteur3d v1, Vecteur3d v2){
		return (v1.getX() * v1.getX()) + 
			(v1.getY() * v2.getY()) +
			(v1.getZ() * v2.getZ());
	} 

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	
	
	
	
	
	
	

}

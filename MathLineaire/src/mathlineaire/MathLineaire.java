/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mathlineaire;

import mathlineaire.module.Matrice;
import mathlineaire.module.Vecteur3d;

/**
 *
 * @author XAMPY
 */
public class MathLineaire {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Matrice A = new Matrice(2, 3);
		
		A.show();
		
		
		System.out.println("\n");
		Vecteur3d v = new Vecteur3d(2, 3, 4);
		v.show();
	}

}

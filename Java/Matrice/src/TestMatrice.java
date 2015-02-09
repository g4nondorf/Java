/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class TestMatrice {
    
    public static void main(String[] args){
        Matrice matA = new Matrice(3,4);
        System.out.println(matA);
        System.out.println("nb Ligne : " + matA.getNbLignes() + "\nnb colonne : " + matA.getNbColonnes() + "\n");
        
        Matrice matB = new Matrice(4,3);
        System.out.println(matB);
        
        Matrice matSomme = matA.ajouter(matB);
        System.out.println(matSomme);
        
        Matrice matMulti = matA.multiplier(matB);
        System.out.println(matMulti);
    }
    
}

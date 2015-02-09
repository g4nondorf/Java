
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Matrice {
    
    private int[][] matrice;
    
    public Matrice(){//une méthode de constructeur
        System.out.print("Quelle nombre de colonne voulez vous pour votre tableau?\n : ");
        int nbrColonne = Clavier.lireInt();
        System.out.print("Quelle nombre de ligne voulez vous pour votre tableau?\n : ");
        int nbrLigne = Clavier.lireInt();
        matrice = new int[nbrLigne][nbrColonne];
        
        for(int i = 0; i < nbrLigne; i++){
            for(int j = 0; i < nbrColonne; i++){
                System.out.print("Quelle valeur pour la case de ligne " + i + " et de colonne " + j + " ?");
                matrice[i][j] = Clavier.lireInt();
            }
        }
    }
    
    public Matrice(int nbrLigne, int nbrColonne){//Autre méthode d'initialisation
        Random r = new Random();
        matrice = new int[nbrLigne][nbrColonne];
        
        for(int i = 0; i < nbrLigne; i++){
            for(int j = 0; j < nbrColonne; j++){
                matrice[i][j] = r.nextInt(10);
            }
        }
    }
    
    public int getNbLignes(){
        return matrice.length;
    }
    
    public int getNbColonnes(){
        return matrice[0].length;
    }
    
    public String toString(){
        String chaine = "";
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[0].length; j++){
                    chaine += matrice[i][j] + " ";
            }
            chaine += "\n";
        }
        return chaine;
    }
    
    public Matrice ajouter(Matrice mat){
        Matrice mat1 ;
        
        if(matrice.length == mat.getNbLignes() && matrice[0].length == mat.getNbColonnes()){
            mat1 = new Matrice(matrice.length,matrice[0].length);
            for(int i = 0; i < matrice.length; i++){
                for(int j = 0; j < matrice[0].length; j++){
                    mat1.setElement(i, j, matrice[i][j] + mat.getElement(i, j));
                }
            }
            return mat1;
        }else{
            mat1 = new Matrice(0,0);
            System.out.println("Addition impossible");
            return mat1;
        }
    }
    
    public Matrice multiplier(Matrice mat){
        Matrice mat1;
        int valeur = 0;
        
        if(matrice.length == mat.getNbColonnes() && matrice[0].length == mat.getNbLignes()){
            mat1 = new Matrice(matrice.length,mat.getNbColonnes());
            for(int  k = 0; k < matrice.length; k++){
                for(int i = 0; i < mat.getNbColonnes() ; i++){
                    for(int j = 0; j < mat.getNbLignes(); j++){
                        valeur += matrice[k][j]*mat.getElement(j,i);
                    }
                    mat1.setElement(k, i, valeur);
                    valeur = 0;
                }
            }
            return mat1;
        }else{
            mat1 = new Matrice(0,0);
            System.out.println("Multiplication impossible");
            return mat1;
        }
    }
    
    public int getElement(int ligne,int colonne){
        return matrice[ligne][colonne];
    }
    
    public void setElement(int ligne,int colonne,int valeur){
        matrice[ligne][colonne] = valeur;
    }
    
}

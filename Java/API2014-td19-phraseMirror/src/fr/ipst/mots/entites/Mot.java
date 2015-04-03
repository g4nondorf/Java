package fr.ipst.mots.entites;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Mot {

    private String valeur;

    public Mot(String valeur) {
        this.valeur = valeur;
    }


    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }


        public Mot miroir(){

		String r="";
		for(int i = valeur.length()-1; i >= 0 ; i--){
			r = r + valeur.charAt(i);
		}


		return new Mot(r);
    }


}

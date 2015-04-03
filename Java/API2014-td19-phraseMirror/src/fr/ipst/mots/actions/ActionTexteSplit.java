package fr.ipst.mots.actions;


import fr.ipst.mots.entites.Mot;

public class ActionTexteSplit{
    	public Mot executer ( Mot m){
            String r ="";
            String s = m.getValeur();
            String [] t = s.split(" ");
            for(int i = 0; i < t.length; i++){
                Mot c = new Mot(t[i]);
                r = r + c.miroir().getValeur() + ' '; 

            }
		
            return new Mot(r);
	}

}
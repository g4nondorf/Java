package fr.ipst.chiffres.metier;


import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class Nombre {
    private long[] chiffres = null;
     
    public Nombre(String[] mots) {
        for(String s: mots){
            if(! s.equalsIgnoreCase("et")){
                ajouter(new Chiffre(s).getValeur());
            }
        }
    }

    public long[] getChiffres() {
        return chiffres;
    }

    public void setChiffres(long[] chiffres) {
        this.chiffres = chiffres;
    }

    private void ajouter(long n){
        if(chiffres == null){
            chiffres = new long[1];  
            chiffres[0] = n;
        }else{
            long [] tab = Arrays.copyOf(chiffres, chiffres.length + 1);
            //cette instruction est équivalente à 
            //            long tab = new long[chiffres.length + 1];
            //            for(int i= 0; i < chiffres.length; i++){
            //                tab[i] = chiffres[i];
            //            }
            tab[chiffres.length] = n;
            chiffres = tab;
        }
    }
    
    public long getValeur(){
        imprimer();
        traiter_quatre_vingt();
        imprimer();
        traiter_cent();
        imprimer();
        traiter_mille_million_milliard();
        imprimer();
        long l = additionner();
        return l;
    }
    
	/** parcourir le tableau chiffres
	   remplacer chaque accurrence de 4 suivi de 20 par 80
	   le résultat est dans un nouveau tableau qui remplace nombres
	**/
    	private void traiter_quatre_vingt(){
		int i;
		int count = -1;
		long [] tab = new long [chiffres.length];
		for(i =1; i < chiffres.length; i++){
			count++;
			if(chiffres[i-1]==4 && chiffres[i]==20){
				tab[count]=80;
				i++;
			}
			else{
				tab[count] = chiffres[i-1];
			}
		}
		if(i-1 < chiffres.length){
			count ++;
			tab[count] = chiffres[i-1];
		}
		count ++;
                tab = Arrays.copyOf(tab, count);
                chiffres = tab;
	}

        /** parcourir le tableau nombres
	   chercher les occurrences de 100,
	   si le nombre juste avant est >0 et <=9 remplacer par le produit
	   le résultat est dans un nouveau tableau qui remplace nombres
	**/
        
	private void traiter_cent(){
		int i;
		int n = chiffres.length;
		int count = -1;
		long [] tab = new long [n];
		for( i = 1; i< n ;i++){
			count ++;
			if((chiffres[i-1]>=0 && chiffres[i-1]<=9) && chiffres[i]==100){
				tab[count] = chiffres[i-1] * chiffres[i];
				i++;
			}
			else{
				tab[count] = chiffres[i-1];
			}
		}
		if(i-1 < n){
			count ++;
			tab[count] = chiffres[i-1];
		}
		count ++;
                tab = Arrays.copyOf(tab, count);
                chiffres = tab;
	}

        
	 /* effectuer la somme des nombres pr�c�dant mille, million, milliard
	    multiplier ces facteurs par le nombre correspondant 1000, 1000000, 1000000000
	 */
        private void traiter_mille_million_milliard(){
		 int n = chiffres.length ;
		 int count = -1;
		 long [] tab = new long[chiffres.length];
		 for(int i = 0; i < n; i++){
			count ++;
			long s=0;
			while(i<n && chiffres[i] != 1000000000 && chiffres[i] != 1000000 && chiffres[i] != 1000){
				s += chiffres[i];
				i++;
			}
			if(i < n) {
				tab[count] = chiffres[i] * ( s == 0 ? 1 : s);
			}else{
				tab[count] = s;
                        }
		 }
		count ++;
                tab = Arrays.copyOf(tab, count);
                chiffres = tab;
	 }

	 /*faire la somme des �l�ments de nombres*/
	 private  long additionner(){
		 long v = 0;
		 for(int i=0; i<chiffres.length; i++){
			 v += chiffres[i];
                 }
		 return v;
	 }

         private void imprimer(){
             System.out.print("{");
		for(int i = 0; i < chiffres.length ; i++){
			System.out.print(chiffres[i] + ", ");
                }
		System.out.println("\b\b}");
	 }
	 

}

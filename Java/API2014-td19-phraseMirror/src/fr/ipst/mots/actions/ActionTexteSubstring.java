package fr.ipst.mots.actions;

import fr.ipst.mots.entites.Mot;

public class ActionTexteSubstring {

    public Mot executer(Mot m) {
        String r = "";
        String s = m.getValeur();
        int i ;
        while ((i = s.indexOf(' ')) != -1) {
            String p = s.substring(0, i);
            Mot c = new Mot(p);
            r = r + c.miroir().getValeur() + ' ';
            s = s.substring(i + 1);
        }
        Mot c = new Mot(s);
        r = r + c.miroir().getValeur();

        return new Mot(r);
    }
}
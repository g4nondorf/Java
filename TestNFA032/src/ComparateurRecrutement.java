
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 * @param <Employe>
 */
public class ComparateurRecrutement implements Comparator<Employe> {

    @Override
    public int compare(Employe t, Employe t1) {
         return t.getDateEmbauche().compareTo(t1.getDateEmbauche());
    }
    
}

package fr.ipst.chiffres.actions;


import fr.ipst.chiffres.metier.Nombre;
import fr.ipst.chiffres.metier.NombreBuilder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadj
 */
public class ActionConversion {
    public long convertir(String s){
        Nombre n = NombreBuilder.construireNombre(s);
        long d = n.getValeur();
        return d;
    }
}

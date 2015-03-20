/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Controleur {
    public static void main(String[] args){
        CouplesHomogenes<String> c1 = new CouplesHomogenes<String>("abc", "def");
        CouplesHomogenes<Integer> c = new CouplesHomogenes<Integer>(new Integer(5), new Integer(6));
        c.echanger();
        Integer i = c.getA();
        
        CouplesHomogenes<Object> c2 = new CouplesHomogenes<Object>(new Integer(5), "cheval");
        Object o = c2.getA();
    }
}

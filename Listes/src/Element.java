/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Element {
    private Object obj;
    private Element suivant;

    public Object getObj() {
        return obj;
    }

    public Element getSuivant() {
        return suivant;
    }
    
    public Element(Object o){
        this.obj = o;
        this.suivant = null;
    }
    
    public Element(Object o, Element e){
        this.obj = o;
        this.suivant = e;
    }
    
    public void chainer(Element e){
        this.suivant = e;
    }
}

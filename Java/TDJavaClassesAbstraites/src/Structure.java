/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class Structure {
    private FigureGéométrique[] formes = new FigureGéométrique[30];

    public FigureGéométrique[] getFormes() {
        return formes;
    }
    int nbFormes = 0;
    
    public void add(FigureGéométrique f){
        formes[nbFormes] = f;
        nbFormes ++;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        for(int i = 0; i < nbFormes; i++){
            s += formes[i].toString() + "\n\n";
        }
        
        return s;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Moi
 */
public enum Frequence {
  AllTime("Tout les jours ou presque", 1),
  DeuxSemaine("Deux déplacement par semaine au minimum", 2),
  DeuxMois("Deux déplacement par mois au minimum", 3),
  Exceptio("Exceptionnellement", 4),
  Jamais("Jamais", 5);

  public String name;
  public int code;
  
  //Constructeur
  Frequence(String name,int code){
    this.code = code;
    this.name = name;
  }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}

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
public enum PossessionV {
  Menage("Possédé par le ménage", 1),
  EmpTotal("Possédé par l'employeur mais à disposition total d'une personne", 2),
  EmpPartiel("Possédé par l'employeur mais à disposition limité d'une personne", 3),
  Autre("Autre", 4);

  public String name;
  public int code;
  
  //Constructeur
  PossessionV(String name,int code){
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

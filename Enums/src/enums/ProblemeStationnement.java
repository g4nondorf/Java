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
public enum ProblemeStationnement {
  Oui("oui", 1),
  NonPlace("Non, j'ai une place réservée", 2),
  NonDispo("Non, il y a une offre importante de stationnement à proximité", 3),
  NonHoraire("Non,compte tenu de mes horaires", 4);

  public String name;
  public int code;
  
  //Constructeur
  ProblemeStationnement(String name,int code){
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

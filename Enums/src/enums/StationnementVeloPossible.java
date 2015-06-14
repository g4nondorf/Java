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
public enum StationnementVeloPossible {
  Oui("Oui", 1),
  NonRese("Non, care je pourrais avoir une place réservée", 2),
  NonDispo("Non, il y a une offre importante de stationnement à proximité", 3);

  public String name;
  public int code;
  
  //Constructeur
  StationnementVeloPossible(String name,int code){
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

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
public enum PossessionHabitat {
  Proprio("Propriétaire ou accédant à la propriété", 1),
  LocaHLM("Lacataire HLM", 2),
  Loca("Autre locataire", 3),
  LogeFree("Logé gratuitement", 4),
  ResiUni("Locataire en résidence universitaire", 5),
  Autre("Autres", 6);

  public String name;
  public int code;
  
  //Constructeur
  PossessionHabitat(String name,int code){
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

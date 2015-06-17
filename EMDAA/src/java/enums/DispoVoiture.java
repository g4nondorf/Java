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
public enum DispoVoiture {
  OuiTotal("Oui et je l'utilise jusqu'à mon lieu de travail ou d'études", 1),
  OuiPartiel("Oui mais je ne l'utilise que sur un partie du déplacement", 2),
  OuiNon("Oui mais je ne l'utilise pas", 3),
  Non("Non", 4);

  public String name;
  public int code;
  
  //Constructeur
  DispoVoiture(String name,int code){
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

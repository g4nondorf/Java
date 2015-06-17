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
public enum Habitat {
  IndIs("Individuel isolé", 1),
  IndAcc("Individuel accolé", 2),
  PetCol("Petit collectif(Jusqu'à 3 étages au-dessus du rez-de-chaussé)", 3),
  GraCol("Grand collectif (plus de 3 étages)", 4),
  Autre("Autres", 5);

  public String name;
  public int code;
  
  //Constructeur
  Habitat(String name,int code){
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

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
public enum EnergieV {
  SPlomb("Sans plomb", 1),
  Super("Super", 2),
  Diesel("Diesel", 3),
  Gaz("Gaz", 4),
  Elec("Electrique", 5),
  Hybr("Hybride", 6),
  Autre("Autre", 7);

  public String name;
  public int code;
  
  //Constructeur
  EnergieV(String name,int code){
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

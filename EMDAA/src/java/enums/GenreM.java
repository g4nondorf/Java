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
public enum GenreM {
  Cyclo("Cyclomoteur", 1),
  Scoot("Scooter", 2),
  Moto("Moto", 3),
  TroisRoue("3 roue motorisé", 4);

  public String name;
  public int code;
  
  //Constructeur
  GenreM(String name,int code){
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

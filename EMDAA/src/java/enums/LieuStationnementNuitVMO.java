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
public enum LieuStationnementNuitVMO {
  Garage("Dans un garage, box ou autre emplacement réservé", 1),
  Rue("Dans la rue", 2),
  ParcOuvert("Dans un parc de stationnement à ciel ouvert (ou place publique)", 3),
  ParcFerme("Dans un parc de stationnement couvert accessible au public", 4);

  public String name;
  public int code;
  
  //Constructeur
  LieuStationnementNuitVMO(String name,int code){
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

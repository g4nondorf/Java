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
public enum Stationnement {
  ArretMinute("Arrêt pour prendre ou déposer une personne; prendre du carburant", 0),
  Garage("Garage, box, autre emplacement réservé", 1),
  Rue("Dans la rue", 2),
  ParcCielOuvert("Dans un parc de stationnement à ciel ouvert (ou place publique)", 3),
  ParcCouvert("Dans un parc de stationnement couvert accessible au public", 4),
  ParcRelai("Dans un parc relais du réseau de transports urbains ou interurbains (cf liste)", 5);

  public String name;
  public int code;
  
  //Constructeur
  Stationnement(String name,int code){
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

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
public enum GenreV {
  Tourisme("Véhicule de tourisme (berline, monospace, break, comercial)", 1),
  CampCar("Camping-car", 2),
  Util("Véhicule utilitaire (800kg à 1000kg decharge utile)", 3),
  SanPerm("Voiture sans permis", 4);

  public String name;
  public int code;
  
  //Constructeur
  GenreV(String name,int code){
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

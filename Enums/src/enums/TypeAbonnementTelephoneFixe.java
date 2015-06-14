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
public enum TypeAbonnementTelephoneFixe {
  FTRedList("Abonné France télécom, sur liste rouge", 1),
  FTAntiPros("Abonné France télécom, sur la liste anti-prospection (ex : liste orange)", 2),
  FTAnnuAbo("Abonné France télécom, sur l'annuaire des abonnés", 3),
  Autre("Abonné d'un autre opérateur (Free, SFR, Numericable, ...)", 4);

  public String name;
  public int code;
  
  //Constructeur
  TypeAbonnementTelephoneFixe(String name,int code){
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

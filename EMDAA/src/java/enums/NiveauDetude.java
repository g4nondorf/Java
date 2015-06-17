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
public enum NiveauDetude {
  Scol("En cours de scolarité", 0),
  Primaire("Primaire", 1),
  Second6a3("Secondaire (de la 6e à la 3e, CAP)", 2),
  SecondFin("Secondaire (de la seconde à la terminale, BEP), non titulaire du BAC", 3),
  SecondBAC("Secondaire, titulaire du BAC", 4),
  SupP2("Supérieur jusqu'à bac +2", 5),
  Sup3etP("Supérieur, bac +3 et plus", 6),
  AppPriOuSec("Apprentissage (école primaire ou secondaire uniquement)", 7),
  AppSup("Apprentissage (études supérieurs", 8),
  Non("Pas d'études", 9);

  public String name;
  public int code;
  
  //Constructeur
  NiveauDetude(String name,int code){
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

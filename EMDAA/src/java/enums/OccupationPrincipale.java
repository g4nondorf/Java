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
public enum OccupationPrincipale {
  PleinT("Travail à plein temps", 1),
  TPartiel("Travail à temps partiel", 2),
  Appr("Apprentissage, formation, stage", 3),
  Etud("Etudiant", 4),
  Scolaire("Scolaire jusqu'au BAC", 5),
  Chomeur("Chômeur et/ou recherche un emploi", 6),
  Retraité("Retraité", 7),
  Foyer("Reste au foyer", 8),
  Autre("Autre", 9);

  public String name;
  public int code;
  
  //Constructeur
  OccupationPrincipale(String name,int code){
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

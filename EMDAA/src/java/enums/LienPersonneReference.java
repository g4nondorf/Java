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
public enum LienPersonneReference {
  Pers("Personne de référence", 1),
  Conjoint("Conjoint", 2),
  Enfant("Enfant", 3),
  Loca("Colocataire, locataire ou sous-locataire", 4),
  AutreSans("Autre (sans lien de parenté)", 5),
  AutreAvec("Autre (avec lien de parenté)", 6);

  public String name;
  public int code;
  
  //Constructeur
  LienPersonneReference(String name,int code){
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

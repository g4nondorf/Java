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
public enum PossessionPermis {
  Oui("Oui", 1),
  Non("Non", 2),
  CondAcc("Conduite accompagnée et leçon de conduite", 3);

  public String name;
  public int code;
  
  //Constructeur
  PossessionPermis(String name,int code){
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

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
public enum TypeOccupation {
  Princi("Emploi principal", 1),
  Second("Emploi secondaire", 2),
  Etude("Etude", 3);

  public String name;
  public int code;
  
  //Constructeur
  TypeOccupation(String name,int code){
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

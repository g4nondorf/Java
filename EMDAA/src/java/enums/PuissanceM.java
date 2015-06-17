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
public enum PuissanceM {
  Moins50("Inférieur à 50cm3", 1),
  De50a125("De 50 à 125cm3", 2),
  De126a250("De 126 à 250cm3", 3),
  De251a750("De 251 à 750cm3", 4),
  Plus750("Plus de 750cm3", 5),
  Moins4KW("Electrique jusqu'à 4KW", 6),
  De4a11("Electrique de 4 à 11KW", 7),
  Plus11("Electrique supérieur à 11KW", 8);

  public String name;
  public int code;
  
  //Constructeur
  PuissanceM(String name,int code){
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

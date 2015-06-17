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
public enum ProblemeStationnementPossible {
  OuiLieuAbr("Oui, dans l'enceinte du lieu et abrité", 1),
  OuiLieu("Oui, dans l'enceinte du lieu mais non abrité", 2),
  OuiProxAbr("Oui, à proximité du lieu et abrité", 3),
  OuiProx("Oui, à proximité du lieu mais non abrité", 4),
  Non("Non", 5);

  public String name;
  public int code;
  
  //Constructeur
  ProblemeStationnementPossible(String name,int code){
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

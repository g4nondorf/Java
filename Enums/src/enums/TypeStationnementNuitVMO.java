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
public enum TypeStationnementNuitVMO {
  Non("Interdit", 1),
  Grat("Gratuit", 2),
  PayCharge("Payant, au moin partiellement à votre charge", 3),
  PayAutre("Payant, entièrement à la charge de quelqu'un d'autre (association, employeur, ...)", 4);

  public String name;
  public int code;
  
  //Constructeur
  TypeStationnementNuitVMO(String name,int code){
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

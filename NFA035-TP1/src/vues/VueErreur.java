/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

/**
 * 
 * @author Hadj
 */
public class VueErreur {
  public void afficher(Exception e) {
        System.out.println("ERREUR : " + e.getMessage());
  }

}

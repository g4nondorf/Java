/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moi
 */
public class TestFormes {
    public static void main(String[] args){
        Structure s = new Structure();
        s.add(new Cercle(3));
        s.add(new Rectangle(3, 6, new Point(0, 2)));
        s.add(new Carré(2));
        s.add(new Carré(2, new Point(4, 1)));
        System.out.println(s);
        System.out.println(s.getFormes()[3].equals(s.getFormes()[4]));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Moi
 */
public class Canvas {
    private static Segment Seg;

    public static void setSeg(Segment Seg1) {
        Seg = Seg1;
    }

    public static Segment getSeg() {
        return Seg;
    }
}

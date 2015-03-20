/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import java.util.HashSet;

/**
 *
 * @author l.glimois
 */
public class SystemeSolaire extends HashSet<Planete>{

    private static SystemeSolaire instance;

    public static SystemeSolaire getInstance() {
        return instance;
    }

    private SystemeSolaire() {
        super();
    }

    public static void creation() {
        instance = new SystemeSolaire();
    }
}

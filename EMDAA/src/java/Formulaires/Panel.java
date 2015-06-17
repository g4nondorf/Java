/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulaires;

/**
 *
 * @author Moi
 */
public class Panel {
    private int numeroPanel;
    private int codeInsee;

    public Panel(int numeroPanel, int codeInsee) {
        this.numeroPanel = numeroPanel;
        this.codeInsee = codeInsee;
    }

    public int getNumeroPanel() {
        return numeroPanel;
    }

    public int getCodeInsee() {
        return codeInsee;
    }
}

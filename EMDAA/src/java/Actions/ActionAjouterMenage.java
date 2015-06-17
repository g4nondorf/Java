/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.DAOFactory;
import DAO.DAOMenage;
import DAO.exceptions.RollbackFailureException;
import Entites.Menage;
import Formulaires.FormMenage;

/**
 *
 * @author LoLo
 */
public class ActionAjouterMenage {
    public void executer(FormMenage menage) throws RollbackFailureException, Exception{
        DAOMenage dao = DAOFactory.getDAOMenage();
        Menage m = new Menage(menage.getNumeroM(),menage.isTelephoneFixe(),menage.getAboTelephone().getCode(),menage.isInternet(),menage.getHabitat().getCode(),menage.getPossessionHabitat().getCode());
        dao.create(m);
    }
}

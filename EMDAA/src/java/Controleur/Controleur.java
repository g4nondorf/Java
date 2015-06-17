/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Actions.ActionAjouterMenage;
import Formulaires.FormMenage;
import enums.Habitat;
import enums.PossessionHabitat;
import enums.TypeAbonnementTelephoneFixe;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LoLo
 */
@WebServlet(name = "Controleur", urlPatterns = {"/control"})
public class Controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String choix = request.getParameter("action");
        try {
            switch (choix) {
                case "menage": {
                    FormMenage menage = new FormMenage();
                    
                    request.setAttribute("menage", menage);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VueMenage.jsp");
                    dispatcher.forward(request, response);
                }
                break;
                    
                case "ajoutermenage" : {
                  String habitat = request.getParameter("habitat");
                  String pht = request.getParameter("Phabitat");
                  String tel = request.getParameter("Ptelephone");
                  FormMenage menage = new FormMenage(5888, true, TypeAbonnementTelephoneFixe.valueOf(tel), true, Habitat.valueOf(habitat), PossessionHabitat.valueOf(pht));
                  new ActionAjouterMenage().executer(menage);
                  
                }
                break;
            }
        }catch(Exception e){
            
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

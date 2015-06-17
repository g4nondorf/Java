<%-- 
    Document   : VueMenage
    Created on : 16 juin 2015, 21:08:34
    Author     : LoLo
--%>



<%@page import="enums.*"%>
<%@page import="Formulaires.FormMenage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="menage" scope="request" class="FormMenage" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form action='control'>
            <input type='hidden' name='action' value='ajoutermenage'>     
            <li>
            <% for (Habitat a : menage.getHabitat().values()) {%>
            <ul>
            <INPUT type="radio" name="habitat" value="<%=a%>"><%= a.name%>
            </ul>
            <% }%>
            </li>
            <Br>
             <% for (PossessionHabitat a : menage.getPossessionHabitat().values()) {%>

            <INPUT type="radio" name="Phabitat" value="<%=a%>"><%= a.name%>

            <% }%>
             <% for (TypeAbonnementTelephoneFixe a : menage.getAboTelephone().values()) {%>

            <INPUT type="radio" name="Ptelephone" value="<%=a%>"><%= a.name%>

            <% }%>
            <input type='submit' name='submit' value='OK'>
        </FORM>

    </body>
</html> 

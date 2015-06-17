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
public enum TypeActivite {
  Domicile("Domicile (partir de, se rendre à)", 01),
  ResiSecond("Résidence secondaire, logement occasionnel, hôtel, autre domicile (partir de, se rendre à)", 02),
  TravailDeclare("Travailler dur le lieu d'emploi déclaré", 11),
  TeleTravail("Travailler sur un autre lieu - télétravail", 12),
  TravailAutre("Travailler sur un autre lieu hors télétravail", 13),
  Garde("Etre gardé (Nourrice, crèche, ...)", 21),
  EtudePrimaire("Etudier sur le lieu d'études déclaré (école maternelle et primaire)", 22),
  EtudeCollege("Etudier sur le lieu d'études déclaré (collége)", 23),
  EtudeLycee("Etudier sur le lieu d'études déclaré (lycée)", 24),
  EtudeSup("Etudier sur le lieu d'études déclaré (universités et grandes écoles)", 25),
  EtudeAutrePrimaire("Etudier sur un autre lieu (école maternelle et primaire)", 26),
  EtudeAutreCollege("Etudier sur un autre lieu (collége)", 27),
  EtudeAutreLycee("Etudier sur un autre lieu (lycée)", 28),
  EtudeAutreSup("Etudier sur un autre lieu (universités et grandes écoles)", 29),
  VisiteCC("Visite d'un magasin, d'un centre commercial ou d'un marché en plein vent sans effectuer d'achat (maximum 3 consecutifs : CF code 82", 30),
  MotifsCC("Realiser plusieurs motifs en centre commercial", 31),
  AchatsGM("Faire des achats en grand magasin, supermarché, hypermarché et leurs galeries marchandes", 32),
  AchatsPC("Faire des achats en petit, moyen commerce et \"drive-in\"", 33),
  AchatsMarche("Faire des achats en marché couvert et de plein vent", 34),
  AchatsDrive("Faire des achats dans un magasin \"drive\"", 35),
  Soins("Recevoir des soins", 41),
  Demarche("Faire une demarche autre que rechercher un emploi", 42),
  RechercheEmp("Rechercher un emploi", 43),
  Loisirs("Participer à des loisirs, des activités sportives, culturelles ou associatives", 51),
  Sortie("Faire une promenade, du \"lèche-vitrine\", prendre une leçon de conduite", 52),
  Restaurer("Se restaurer hors du domicile", 53),
  VisiteAmis("Visiter des parents ou des amis", 54),
  AccQlqPre("Accompagner quelqu'un (personne présente)", 61),
  CheQlqPre("Aller chercher quelqu'un (personne présente)", 62),
  AccQlqAbs("Accompagner quelqu'un (personne absente)", 63),
  CheQlqAbs("Aller chercher quelqu'un (personne absente)", 64),
  DepQlqPre("Déposer une personne à un mode de transport (personne présente)", 71),
  PrenQlqPre("Reprendre une personne à un mode de transport (personne présente)", 72),
  DepQlqAbs("Déposer une personne à un mode de transport (personne absente)", 73),
  PrenQlqAbs("Reprendre une personne à un mode de transport (personne absente)", 74),
  TournePro("Réaliser une tournée professionnelle", 81),
  VisiteCC3plus("Réaliser une tournée de magasins sans effectuer d'achet (au delà de 3 déplacements code 30 consecutifs)", 82),
  Autre("Autres motifs", 91);

  public String name;
  public int code;
  
  //Constructeur
  TypeActivite(String name,int code){
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

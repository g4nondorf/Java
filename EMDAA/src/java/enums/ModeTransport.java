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
public enum ModeTransport {
  ConVelo("Conducteur de vélo", 11),
  PassVelo("Passager de vélo", 12),
  ConMoin50("Conducteur de deux ou trois roues motorisés <50cm3", 13),
  PassMoin50("Passager de deux ou trois roues motorisés <50cm3", 14),
  ConPlus50("Conducteur de deux ou trois roues motorisés >=50cm3", 15),
  PassPlus50("Passager de deux ou trois roues motorisés >=50cm3", 16),
  ConVP("Conducteur de véhicule particulier(VP)", 21),
  PassVP("Passager de véhicule particulier(VP)", 22),
  PassBus("Passager bus ou car urbain", 31),
  PassTram("Passager tramway", 32),
  PassMetro("Passager métro", 33),
  PassAutre("Passager autre réseau urbain", 39),
  PassColl("Passager transports collectifs départementaux", 41),
  PassAutreBus("Passager autres autocars", 42),
  PassTrain("Passager train", 51),
  PassTaxi("Passager taxi", 61),
  TransEmp("Transport employeur (exclusivement)", 71),
  ConCamion("Conducteur de fourgon, camionnette, camion", 81),
  PassCamion("Passager de fourgon, camionnette, camion", 82),
  TransFluvial("Transport fluvial ou maritime", 91),
  Avion("Avion", 92),
  Roller("Roller, skate, trottinette", 93),
  Fauteuil("Fauteuil roulant", 94),
  Autre("Autres modes (tracteur, engin agricole, quad, ect...", 95);

  public String name;
  public int code;
  
  //Constructeur
  ModeTransport(String name,int code){
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

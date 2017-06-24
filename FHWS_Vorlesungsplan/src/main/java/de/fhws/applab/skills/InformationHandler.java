package de.fhws.applab.skills;

/**
 * Created by Konrad Melzer on 24.06.2017.
 */
public class InformationHandler {

  public String requestInformation(String lecture){
    return Constants.map.get(lecture.toLowerCase());
  }
  
}

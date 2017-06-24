package de.fhws.applab.skills;

import de.fhws.applab.skills.DataStructure.Event;
import de.fhws.applab.skills.Http.HttpHandler;
import de.fhws.applab.skills.Json.JsonHandler;
import java.util.List;

/**
 * Created by Konrad Melzer on 24.06.2017.
 */
public class DayRequestHandler {

  public DayRequestHandler(){

  }

  public List<Event> requestEventList(String date){
    HttpHandler h = new HttpHandler();
    JsonHandler jh = new JsonHandler();

    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day="+date);
    return jh.getEventArray(s);
  }

  public static void main(String[] args){
    DayRequestHandler h = new DayRequestHandler();
    List<Event> e = h.requestEventList("24.06.2017");
    System.out.print(e);

  }

}

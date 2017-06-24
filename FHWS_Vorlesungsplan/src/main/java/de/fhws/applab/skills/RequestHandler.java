package de.fhws.applab.skills;

import de.fhws.applab.skills.DataStructure.Event;
import de.fhws.applab.skills.Http.HttpHandler;
import de.fhws.applab.skills.Json.JsonHandler;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Konrad Melzer on 24.06.2017.
 */
public class RequestHandler {
  HttpHandler h = new HttpHandler();
  JsonHandler jh = new JsonHandler();


  public RequestHandler(){

  }

  public List<Event> requestEventListByDate(String date){
    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day="+date);
    return jh.getEventArray(s);
  }

  public List<Event> requestEventListByDateAndLecturer(String date, String lecturer){
    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day="+date);
    return jh.getEventArray(s).stream().filter(x -> x.getLecturerView().size() > 0 && x.getLecturerView().get(0).getLastName().equals(lecturer)).collect(Collectors.toList());
  }

  public List<Event> requestEventListByDateAndRoom(String date, String room){
    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day="+date);
    return jh.getEventArray(s).stream().filter(x -> x.getRoomsView().size() > 0 && x.getRoomsView().get(0).getRoom().equals(room)).collect(Collectors.toList());
  }

  public List<Event> requestEventListByDateAndLecture(String date, String lecture){
    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day="+date);
    return jh.getEventArray(s).stream().filter(x -> x.getName().equals(lecture)).collect(Collectors.toList());
  }


  public static void main(String[] args){
    RequestHandler h = new RequestHandler();
    List<Event> e = h.requestEventListByDateAndLecturer("24.06.2017", "Blaschka");
    System.out.print(e);

  }

}
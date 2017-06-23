package de.fhws.applab.skills.Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.fhws.applab.skills.dataStructure.Event;
import java.util.ArrayList;


/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class JsonHandler {

  public ArrayList<Event> getEventArray(String jsonEventArray) {
    Gson gson = new Gson();
    ArrayList<Event> e = (ArrayList<Event>) gson.fromJson(jsonEventArray, new TypeToken<ArrayList<Event>>() {}.getType());
    return e;
  }

}

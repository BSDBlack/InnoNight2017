package de.fhws.applab.skills.Json;

import com.google.gson.Gson;


/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class JsonHandler {

  public ArrayList<Event> getEventArray(String jsonEventArray) {
    Gson gson = new Gson();
    return new ArrayList<Event>() = gson.fromJson(jsonEventArray, new TypeToken<ArrayList<Event>>() {}.getType());
  }

}

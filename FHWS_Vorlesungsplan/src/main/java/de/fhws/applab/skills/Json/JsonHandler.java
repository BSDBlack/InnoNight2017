package de.fhws.applab.skills.Json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import de.fhws.applab.skills.DataStructure.Event;
import java.util.List;


/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class JsonHandler {

  public List<Event> getEventArray(String jsonEventArray) throws JsonSyntaxException{
    Gson gson = new Gson();
    List<Event> e = gson.fromJson(jsonEventArray, new TypeToken<List<Event>>() {}.getType());
    return e;
  }

}

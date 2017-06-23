package de.fhws.applab.skills.Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class JsonHandler {

  public ArrayList<Event> getEventArray(String jsonEventArray) {
    Gson gson = new Gson();
    return new ArrayList<Event>() = gson.fromJson(jsonEventArray, new TypeToken<ArrayList<Event>>() {}.getType());
  }

}

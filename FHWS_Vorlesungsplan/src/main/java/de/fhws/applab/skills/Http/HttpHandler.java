package de.fhws.applab.skills.Http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import de.fhws.applab.skills.Json.JsonHandler;
import de.fhws.applab.skills.DataStructure.Event;
import java.io.IOException;
import java.util.List;

/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class HttpHandler {

  public HttpHandler(){
    client = new OkHttpClient();
  }
  public static void main(String[] args) {
    HttpHandler h = new HttpHandler();
    JsonHandler jh = new JsonHandler();

    String s = h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day=28.06.2017");
    jh.getEventArray(s);
    List<Event> e = jh.getEventArray(s);
    System.out.println(e.get(0).getLecturerView().get(0).getFirstName());
    System.out.println(e.get(1).getStartTime());
  }

  OkHttpClient client;

  public String pullJsonStringFromHttp(String url) {

    HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

    Request request = new Request.Builder()
        .url(url)
        .build();


    try {
      String s = client.newCall(request).execute().body().string();
      return s;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

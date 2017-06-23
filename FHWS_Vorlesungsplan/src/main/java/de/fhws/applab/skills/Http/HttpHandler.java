package de.fhws.applab.skills.Http;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import de.fhws.applab.fhws_veranstaltungsplan.Json.JsonHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad Melzer on 23.06.2017.
 */
public class HttpHandler {

  String s;

  public static void main(String[] args) {
    HttpHandler h = new HttpHandler();
    h.pullJsonStringFromHttp("https://apistaging.fiw.fhws.de/mo/api/events?day=27.06.2017");
  }

  OkHttpClient client;

  public HttpHandler() {
    client = new OkHttpClient();
  }

  public String pullJsonStringFromHttp(String url) {

    final List<String> objects = new ArrayList<String>();
    HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

    Request request = new Request.Builder()
        .url(url)
        .build();

    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Request request, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Response response) throws IOException {
        if (!response.isSuccessful()) {
          throw new IOException("Unexpected code " + response);
        } else {
          objects.add(response.body().string());

        }
      }
    });
    return objects.get(0);
  }

}

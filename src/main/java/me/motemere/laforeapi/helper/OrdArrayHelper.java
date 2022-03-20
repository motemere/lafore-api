package me.motemere.laforeapi.helper;

import com.google.gson.Gson;
import me.motemere.code.array.OrdArray;
import org.json.JSONArray;

public class OrdArrayHelper {

  public static OrdArray getOrdArray(String json) {
    JSONArray jsonArray = new JSONArray(json);
    long[] arr = new long[jsonArray.length()];

    for (int i = 0; i < jsonArray.length(); i++) {
      arr[i] = jsonArray.getLong(i);
    }

    // bubble sort included
    return new OrdArray(arr);
  }

  public static String getJson(OrdArray ordArray) {
    return new Gson().toJson(ordArray.getArr());
  }

}

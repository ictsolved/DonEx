package com.example.androidapp.shakyaruja.itsdc.lib.bubble;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleConstraints {
  private JSONArray constraints = new JSONArray();

  public void add(String key, String constraintType, String value) {
    JSONObject con = new JSONObject();

    try {
      con.put("key", key);
      con.put("constraint_type", constraintType);
      con.put("value", value);
    } catch (JSONException e) {
      // do nothing
    }

    constraints.put(con);
  }

  public String constraintsString() {
    return constraints.toString();
  }
}

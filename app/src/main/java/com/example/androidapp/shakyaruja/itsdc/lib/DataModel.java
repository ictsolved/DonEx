package com.example.androidapp.shakyaruja.itsdc.lib;

import java.io.Serializable;

public abstract class DataModel implements Serializable {
  public String toJson() {
    return GsonUtility.createDefaultGson().toJson(this);
  }
}

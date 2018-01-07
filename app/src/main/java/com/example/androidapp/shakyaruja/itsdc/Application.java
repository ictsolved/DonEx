package com.example.androidapp.shakyaruja.itsdc;

import com.example.androidapp.shakyaruja.itsdc.lib.ApplicationPattern;
import com.example.androidapp.shakyaruja.itsdc.lib.HTTPManager;
import android.content.Context;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.provider.CalendarContract;
import com.example.androidapp.shakyaruja.itsdc.lib.google.GoogleDistanceMatrixApi;
import com.example.androidapp.shakyaruja.itsdc.Application;
import android.location.Location;
import com.google.android.gms.maps.model.LatLng;

public class Application extends ApplicationPattern {
  private static final HTTPManager httpManager = new HTTPManager();

  public static HTTPManager getHttpManager() {
    return httpManager;
  }

  public static float dpToPx(float dp, Context context) {
    return dp
        * ((float) context.getResources().getDisplayMetrics().densityDpi
            / DisplayMetrics.DENSITY_DEFAULT);
  }

  public static File drawableToFile(Drawable drawable, String fileName) {
    if (drawable == null || fileName == null) {
      Log.i("DRAWABLE-TO-FILE", "Given Drawable was null, so returning null File");
      return null;
    }

    Bitmap bitmap = null;

    if (drawable instanceof BitmapDrawable) {
      BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
      if (bitmapDrawable.getBitmap() != null) {
        bitmap = bitmapDrawable.getBitmap();
      }
    } else {
      // Create a Bitmap from the drawable
      bitmap =
          Bitmap.createBitmap(
              drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      drawable.draw(canvas);
    }

    Bitmap.CompressFormat format;

    if (fileName.length() >= 5 && fileName.substring(fileName.length() - 3).equals("jpg")) {
      format = Bitmap.CompressFormat.JPEG;
    } else {
      format = Bitmap.CompressFormat.PNG;
    }

    File directory = new File(context.getFilesDir() + File.separator + "images");

    File file = new File(directory, fileName);

    FileOutputStream outputStream = null;

    try {
      directory.mkdirs();
      file.createNewFile();
      file.setWritable(true, false);
      outputStream = new FileOutputStream(file);
      bitmap.compress(format, 100, outputStream);
      outputStream.flush();
      outputStream.close();
      return file;
    } catch (IOException e) {
      Log.e("DRAWABLE-TO-FILE", "Unable to save the provided drawable to disk.", e);
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e1) {
          Log.e("DRAWABLE-TO-FILE", "Unable to close file output stream.", e);
        }
      }
      return null;
    }
  }

  public static @Nullable Long getDefaultCalendarId() {
    String[] projection = {CalendarContract.Calendars._ID, CalendarContract.Calendars.IS_PRIMARY};

    Cursor managedCursor =
        getContext()
            .getContentResolver()
            .query(CalendarContract.Calendars.CONTENT_URI, projection, null, null, null);

    Long calendarId = null;

    if (managedCursor.moveToFirst()) {
      calendarId =
          Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(projection[0])));
    }

    while (managedCursor.moveToNext()) {
      if (managedCursor.getString(managedCursor.getColumnIndex(projection[1])).equals("1")) {
        calendarId =
            Long.parseLong(managedCursor.getString(managedCursor.getColumnIndex(projection[0])));
        break;
      }
    }

    managedCursor.close();

    return calendarId;
  }

  public static float pxToDp(float px, Context context) {
    return px
        / ((float) context.getResources().getDisplayMetrics().densityDpi
            / DisplayMetrics.DENSITY_DEFAULT);
  }

  public static Application getContext() {
    return (Application) context;
  }

  public static Location latLngToLocation(LatLng latLng) {
    Location loc = new Location("DS");

    loc.setLatitude(latLng.latitude);

    loc.setLongitude(latLng.longitude);

    return loc;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    context = getApplicationContext();

    char[] secret = {
      '2', '3', '5', '2', 'b', '0', '8', 'a', 'f', '2', '0', '0', 'e', '2', '0', 'c', '3', '2', '2',
      '4', '0', 'd', '4', '8', '3', '0', '2', '0', '0', 'e', '0', 'a'
    };

    setSharedPrefs(secret);

    GoogleDistanceMatrixApi.setApiKey(this);
  }

  public static class TypeConverters {
    public static Double toDouble(Long v) {
      return v.doubleValue();
    }

    public static Float toFloat(Integer v) {
      return v.floatValue();
    }

    public static Integer toInt(Long v) {
      return v.intValue();
    }

    public static Double toDouble(Integer v) {
      return v.doubleValue();
    }

    public static Double toDouble(long v) {
      return (double) v;
    }

    public static Long toLong(Integer v) {
      return v.longValue();
    }

    public static Double toDouble(int v) {
      return (double) v;
    }

    public static Double toDouble(float v) {
      return (double) v;
    }

    public static Long toLong(String v) {
      try {
        return toLong(Double.parseDouble(v.replaceAll("[^\\d.-]", "")));
      } catch (NumberFormatException e) {
        return null;
      }
    }

    public static Long toLong(int v) {
      return (long) v;
    }

    public static Integer toInt(Float v) {
      return v.intValue();
    }

    public static Long toLong(Double v) {
      return v.longValue();
    }

    public static Float toFloat(String v) {
      try {
        return toFloat(Double.parseDouble(v.replaceAll("[^\\d.-]", "")));
      } catch (NumberFormatException e) {
        return null;
      }
    }

    public static Long toLong(double v) {
      return (long) v;
    }

    public static Integer toInt(Double v) {
      return v.intValue();
    }

    public static Float toFloat(Long v) {
      return v.floatValue();
    }

    public static Integer toInt(float v) {
      return (int) v;
    }

    public static Float toFloat(int v) {
      return (float) v;
    }

    public static Integer toInt(double v) {
      return (int) v;
    }

    public static Integer toInt(String v) {
      try {
        return toInt(Double.parseDouble(v.replaceAll("[^\\d.-]", "")));
      } catch (NumberFormatException e) {
        return null;
      }
    }

    public static Long toLong(float v) {
      return (long) v;
    }

    public static Float toFloat(long v) {
      return (float) v;
    }

    public static Float toFloat(Double v) {
      return v.floatValue();
    }

    public static Integer toInt(long v) {
      return (int) v;
    }

    public static Double toDouble(Float v) {
      return v.doubleValue();
    }

    public static Double toDouble(String v) {
      try {
        return Double.parseDouble(v.replaceAll("[^\\d.-]", ""));
      } catch (NumberFormatException e) {
        return null;
      }
    }

    public static Float toFloat(double v) {
      return (float) v;
    }

    public static Long toLong(Float v) {
      return v.longValue();
    }
  }
}

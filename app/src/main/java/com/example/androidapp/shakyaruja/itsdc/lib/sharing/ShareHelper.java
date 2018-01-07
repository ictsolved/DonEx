package com.example.androidapp.shakyaruja.itsdc.lib.sharing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import com.example.androidapp.shakyaruja.itsdc.Application;
import android.util.Log;

public class ShareHelper {
  private static final String CHOOSE = "Choose An Application";

  public static void shareText(Context context, String shareSubject, String shareText) {
    Intent sendIntent = new Intent();

    sendIntent.setAction(Intent.ACTION_SEND);

    if (shareSubject != null) sendIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);

    sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);

    sendIntent.setType("text/plain");

    context.startActivity(Intent.createChooser(sendIntent, CHOOSE));
  }

  public static boolean shareImage(Context context, Drawable d) {
    try {
      File outputFile =
          Application.drawableToFile(d, "sharedrawable" + System.currentTimeMillis() + ".png");
      Uri uri = null;
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        uri =
            FileProvider.getUriForFile(context, context.getPackageName() + ".provider", outputFile);
      } else {
        uri = Uri.fromFile(outputFile);
      }
      Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
      shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
      shareIntent.setData(uri);
      shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      shareIntent.setType("image/png");
      Intent chooserIntent = Intent.createChooser(shareIntent, CHOOSE);
      context.startActivity(chooserIntent);
      return true;
    } catch (Exception e) {
      Log.e("SHARE", "Failed to share drawable", e);
      return false;
    }
  }
}

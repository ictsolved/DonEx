package com.example.androidapp.shakyaruja.itsdc.elements.homeactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View1;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View2;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View3;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View4;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View5;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.View6;
import android.support.v7.widget.AppCompatButton;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import com.example.androidapp.shakyaruja.itsdc.lib.sharing.ShareHelper;
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;

public class ScrollView1 extends ScrollView {
  public View1 view1;

  public View2 view2;

  public View3 view3;

  public View4 view4;

  public View5 view5;

  public View6 view6;

  public AppCompatButton textButton7;

  public ScrollView1(Context context) {
    super(context);
  }

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    this.view1 = (View1) findViewById(R.id.view12);

    this.view2 = (View2) findViewById(R.id.view21);

    this.view3 = (View3) findViewById(R.id.view3);

    this.view4 = (View4) findViewById(R.id.view4);

    this.view5 = (View5) findViewById(R.id.view5);

    this.view6 = (View6) findViewById(R.id.view6);

    textButton7 = (AppCompatButton) findViewById(R.id.text_button7);

    textButton7.setTransformationMethod(null);

    textButton7.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            ShareHelper.shareText(
                ((HomeActivity) getContext()),
                "Download Donate App from Playstore to get rewards on donation that can be redeemed on different shops to get the discount. https://link.to/app",
                "Donate");
          }
        });
  }
}

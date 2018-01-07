package com.example.androidapp.shakyaruja.itsdc.elements.homeactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatButton;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.EventActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.ScrollView1;

public class View1 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton1;

  public AppCompatButton textButton1;

  public View1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public View1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public View1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button12);

    imageButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            HomeActivity activity =
                ((HomeActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent = new Intent(activity, EventActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textButton1 = (AppCompatButton) findViewById(R.id.text_button12);

    textButton1.setTransformationMethod(null);

    textButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            HomeActivity activity1 =
                ((HomeActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent1 = new Intent(activity1, EventActivity.class);
            activity1.startActivity(transitionIntent1);
            activity1.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });
  }
}

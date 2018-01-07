package com.example.androidapp.shakyaruja.itsdc.elements.homeactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatButton;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.ReedemActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.homeactivity.ScrollView1;

public class View5 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton5;

  public AppCompatButton textButton5;

  public View5(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public View5(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public View5(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageButton5 = (AppCompatImageButton) findViewById(R.id.image_button5);

    imageButton5.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            HomeActivity activity =
                ((HomeActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent = new Intent(activity, ReedemActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textButton5 = (AppCompatButton) findViewById(R.id.text_button5);

    textButton5.setTransformationMethod(null);

    textButton5.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            HomeActivity activity1 =
                ((HomeActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent1 = new Intent(activity1, ReedemActivity.class);
            activity1.startActivity(transitionIntent1);
            activity1.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });
  }
}

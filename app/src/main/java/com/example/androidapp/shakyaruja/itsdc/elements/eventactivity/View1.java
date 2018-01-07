package com.example.androidapp.shakyaruja.itsdc.elements.eventactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.DonateActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.EventActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.eventactivity.ScrollView1;

public class View1 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton1;

  public AppCompatTextView textView1;

  public AppCompatTextView textView3;

  public View1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public View1(Context context) {
    super(context);
  }

  public View1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button1);

    imageButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            EventActivity activity =
                ((EventActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent = new Intent(activity, DonateActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view1);

    textView1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            EventActivity activity1 =
                ((EventActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent1 = new Intent(activity1, DonateActivity.class);
            activity1.startActivity(transitionIntent1);
            activity1.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView3 = (AppCompatTextView) findViewById(R.id.text_view3);

    textView3.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view2) {
            EventActivity activity2 =
                ((EventActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent2 = new Intent(activity2, DonateActivity.class);
            activity2.startActivity(transitionIntent2);
            activity2.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });
  }
}

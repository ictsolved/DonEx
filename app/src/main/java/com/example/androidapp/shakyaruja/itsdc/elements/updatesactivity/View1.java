package com.example.androidapp.shakyaruja.itsdc.elements.updatesactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.FullNewsActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.UpdatesActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.updatesactivity.ScrollView1;

public class View1 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton1;

  public AppCompatTextView textView1;

  public AppCompatTextView textView5;

  public View1(Context context) {
    super(context);
  }

  public View1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public View1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageButton1 = (AppCompatImageButton) findViewById(R.id.image_button11);

    imageButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            UpdatesActivity activity =
                ((UpdatesActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent = new Intent(activity, FullNewsActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view11);

    textView1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            UpdatesActivity activity1 =
                ((UpdatesActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent1 = new Intent(activity1, FullNewsActivity.class);
            activity1.startActivity(transitionIntent1);
            activity1.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView5 = (AppCompatTextView) findViewById(R.id.text_view5);

    textView5.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view2) {
            UpdatesActivity activity2 =
                ((UpdatesActivity) ((ScrollView1) getParent().getParent()).getContext());
            Intent transitionIntent2 = new Intent(activity2, FullNewsActivity.class);
            activity2.startActivity(transitionIntent2);
            activity2.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });
  }
}

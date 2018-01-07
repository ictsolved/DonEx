package com.example.androidapp.shakyaruja.itsdc.elements.eventactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.DonateActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.EventActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.eventactivity.ScrollView1;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;

public class View2 extends PercentRelativeLayout {
  public AppCompatImageButton imageButton2;

  public AppCompatTextView textView2;

  public AppCompatTextView textView4;

  public View2(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public View2(Context context) {
    super(context);
  }

  public View2(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageButton2 = (AppCompatImageButton) findViewById(R.id.image_button2);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view2);

    textView2.setOnClickListener(
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

    textView4 = (AppCompatTextView) findViewById(R.id.text_view4);
  }
}

package com.example.androidapp.shakyaruja.itsdc.elements.historyactivity;

import android.support.percent.PercentRelativeLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;

public class View1 extends PercentRelativeLayout {
  public AppCompatTextView textView1;

  public AppCompatTextView textView2;

  public AppCompatTextView textView3;

  public AppCompatTextView textView4;

  public AppCompatTextView textView5;

  public AppCompatTextView textView6;

  public AppCompatTextView textView7;

  public AppCompatTextView textView8;

  public View1(Context context) {
    super(context);
  }

  public View1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public View1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    textView1 = (AppCompatTextView) findViewById(R.id.text_view16);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view24);

    textView3 = (AppCompatTextView) findViewById(R.id.text_view32);

    textView4 = (AppCompatTextView) findViewById(R.id.text_view41);

    textView5 = (AppCompatTextView) findViewById(R.id.text_view51);

    textView6 = (AppCompatTextView) findViewById(R.id.text_view6);

    textView7 = (AppCompatTextView) findViewById(R.id.text_view7);

    textView8 = (AppCompatTextView) findViewById(R.id.text_view8);
  }
}

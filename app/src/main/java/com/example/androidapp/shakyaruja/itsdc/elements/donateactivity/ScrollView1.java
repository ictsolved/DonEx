package com.example.androidapp.shakyaruja.itsdc.elements.donateactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;

public class ScrollView1 extends ScrollView {
  public AppCompatTextView textView2;

  public AppCompatTextView textView3;

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ScrollView1(Context context) {
    super(context);
  }

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    textView2 = (AppCompatTextView) findViewById(R.id.text_view23);

    textView3 = (AppCompatTextView) findViewById(R.id.text_view31);
  }
}

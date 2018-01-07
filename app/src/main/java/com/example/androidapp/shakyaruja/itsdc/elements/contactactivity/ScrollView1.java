package com.example.androidapp.shakyaruja.itsdc.elements.contactactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;

public class ScrollView1 extends ScrollView {
  public AppCompatTextView textView1;

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ScrollView1(Context context) {
    super(context);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    textView1 = (AppCompatTextView) findViewById(R.id.text_view15);
  }
}

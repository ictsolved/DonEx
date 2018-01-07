package com.example.androidapp.shakyaruja.itsdc.elements.historyactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import com.example.androidapp.shakyaruja.itsdc.elements.historyactivity.View1;
import com.example.androidapp.shakyaruja.itsdc.R;

public class ScrollView1 extends ScrollView {
  public View1 view1;

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

    this.view1 = (View1) findViewById(R.id.view13);
  }
}

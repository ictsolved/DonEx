package com.example.androidapp.shakyaruja.itsdc.elements.fullnewsactivity;

import android.widget.ScrollView;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import com.example.androidapp.shakyaruja.itsdc.R;

public class ScrollView1 extends ScrollView {
  public AppCompatImageView imageView1;

  public AppCompatTextView textView1;

  public AppCompatTextView textView2;

  public ScrollView1(Context context) {
    super(context);
  }

  public ScrollView1(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ScrollView1(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  public void onFinishInflate() {
    super.onFinishInflate();

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view1);

    textView1 = (AppCompatTextView) findViewById(R.id.text_view12);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view21);
  }
}

package com.example.androidapp.shakyaruja.itsdc.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.support.v7.widget.Toolbar;

import com.example.androidapp.shakyaruja.itsdc.Pop;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.graphics.PorterDuff;
import android.view.View;
import android.content.Intent;

import com.example.androidapp.shakyaruja.itsdc.elements.donateactivity.ScrollView1;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;
import android.support.v7.widget.AppCompatTextView;

public class DonateActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public ScrollView1 scrollView1;

  public AppCompatImageView imageView1;

  public AppCompatButton textButton1;

  public AppCompatTextView textView1;


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF3949AB"));
    }
  }

  @Override
  protected void onStop() {
    super.onStop();
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.donate);

    mMainLayout = (LinearLayout) findViewById(R.id.donate);

    this.setup();
  }

  public DonateActivity getContext() {
    return this;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar3);

    DonateActivity.this.setSupportActionBar(appBar);

    for (int i = 0; i < appBar.getChildCount(); ++i) {
      View child = appBar.getChildAt(i);
      if (child instanceof TextView) {
        child.setBackgroundColor(Color.TRANSPARENT);
        break;
      }
    }

    appBar.setNavigationIcon(ContextCompat.getDrawable(getContext(), R.drawable.back_btn_ffffffff));

    appBar
        .getNavigationIcon()
        .mutate()
        .setColorFilter(Color.parseColor("#FFFFFFFF"), PorterDuff.Mode.SRC_ATOP);

    appBar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            DonateActivity activity = DonateActivity.this;
            Intent transitionIntent = new Intent(activity, HomeActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    this.scrollView1 = (ScrollView1) findViewById(R.id.scroll_view13);

    imageView1 = (AppCompatImageView) findViewById(R.id.image_view11);

    textButton1 = (AppCompatButton) findViewById(R.id.text_button11);



    textButton1.setTransformationMethod(null);

    textButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            startActivity(new Intent(DonateActivity.this,Pop.class));
            DonateActivity.this.scrollView1.textView3.setText("10");
//            Toast.makeText(DonateActivity.this, "5 Points Obtained!", Toast.LENGTH_SHORT).show();
//              Toast.makeText(DonateActivity.this,"",Toast.LENGTH_SHORT).show();
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view14);
  }
}

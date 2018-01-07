package com.example.androidapp.shakyaruja.itsdc.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.graphics.PorterDuff;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.UpdatesActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.FullNewsActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.fullnewsactivity.ScrollView1;

public class FullNewsActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public ScrollView1 scrollView1;

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.full_news);

    mMainLayout = (LinearLayout) findViewById(R.id.full_news);

    this.setup();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  public FullNewsActivity getContext() {
    return this;
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
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar1);

    FullNewsActivity.this.setSupportActionBar(appBar);

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
          public void onClick(View view) {
            FullNewsActivity activity = FullNewsActivity.this;
            Intent transitionIntent = new Intent(activity, UpdatesActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    this.scrollView1 = (ScrollView1) findViewById(R.id.scroll_view12);
  }
}

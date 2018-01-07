package com.example.androidapp.shakyaruja.itsdc.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.graphics.PorterDuff;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;
import com.example.androidapp.shakyaruja.itsdc.activities.UpdatesActivity;
import com.example.androidapp.shakyaruja.itsdc.elements.updatesactivity.ScrollView1;

public class UpdatesActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public ScrollView1 scrollView1;

  @Override
  protected void onPause() {
    super.onPause();
  }

  public UpdatesActivity getContext() {
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
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.updates);

    mMainLayout = (LinearLayout) findViewById(R.id.updates);

    this.setup();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar2);

    UpdatesActivity.this.setSupportActionBar(appBar);

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
            UpdatesActivity activity = UpdatesActivity.this;
            Intent transitionIntent = new Intent(activity, HomeActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    this.scrollView1 = (ScrollView1) findViewById(R.id.scroll_view11);
  }
}

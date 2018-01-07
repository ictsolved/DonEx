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
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatButton;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.ReedemActivity;

public class ReedemActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public AppCompatTextView textView1;

  public AppCompatTextView textView2;

  public AppCompatButton textButton1;

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF3949AB"));
    }
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

    setContentView(R.layout.reedem);

    mMainLayout = (LinearLayout) findViewById(R.id.reedem);

    this.setup();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  public ReedemActivity getContext() {
    return this;
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar4);

    ReedemActivity.this.setSupportActionBar(appBar);

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
            ReedemActivity activity = ReedemActivity.this;
            Intent transitionIntent = new Intent(activity, HomeActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    textView1 = (AppCompatTextView) findViewById(R.id.text_view13);

    textView2 = (AppCompatTextView) findViewById(R.id.text_view22);

    textButton1 = (AppCompatButton) findViewById(R.id.text_button1);

    textButton1.setTransformationMethod(null);

    textButton1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            new IntentIntegrator(ReedemActivity.this)
                .setBeepEnabled(Boolean.valueOf(true))
                .initiateScan();
          }
        });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

    if (result != null) {
      if (result.getContents() == null) {
        ReedemActivity.this.textView2.setText("10");
      } else {
        String barcodeString = result.getContents();
        String formatString = result.getFormatName();
        ReedemActivity.this.textView2.setText("5");
      }
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }
}

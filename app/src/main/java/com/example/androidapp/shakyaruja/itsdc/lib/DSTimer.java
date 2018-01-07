package com.example.androidapp.shakyaruja.itsdc.lib;

import android.os.CountDownTimer;

public class DSTimer extends CountDownTimer {
  public long intervalInMillis;

  private Protocol del;

  private int subTickCount;

  private static final int tickMultiplier = 10;

  public boolean repeating;

  public long tickIntervalInMillis;

  public DSTimer(
      long countdownIntervalInMillis,
      long tickIntervalInMillis,
      boolean repeating,
      Protocol callback) {
    super(countdownIntervalInMillis, tickIntervalInMillis / tickMultiplier);

    this.intervalInMillis = countdownIntervalInMillis;

    this.tickIntervalInMillis = tickIntervalInMillis;

    this.repeating = repeating;

    this.del = callback;
  }

  @Override
  public void onTick(long millisUntilFinished) {
    subTickCount++;

    if (subTickCount == tickMultiplier) {
      this.del.didTick(this, millisUntilFinished);
      subTickCount = 0;
    }
  }

  @Override
  public void onFinish() {
    if (repeating) {
      subTickCount = 0;
      this.start();
    }

    this.del.didFinish(this);
  }

  public interface Protocol {
    void didTick(DSTimer timer, long timeUntilFinished);

    void didFinish(DSTimer timer);
  }
}

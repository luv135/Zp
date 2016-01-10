package com.luo.zp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.luo.zp.R;
import com.luo.zp.views.RevealBackgroundView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectActivity extends AppCompatActivity implements RevealBackgroundView.OnStateChangeListener {

    @Bind(R.id.boy)
    Button boy;
    @Bind(R.id.girl)
    Button girl;
    @Bind(R.id.action)
    LinearLayout action;
    @Bind(R.id.actionBackground)
    RevealBackgroundView actionBackground;
    private int sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        actionBackground.setFillPaintColor(getResources().getColor(android.R.color.transparent));

    }

    @OnClick(R.id.boy)
    public void boyClick() {
        int[] startingLocation = new int[2];
        boy.getLocationOnScreen(startingLocation);
        startingLocation[0] += boy.getWidth() / 2;
        startingLocation[1] += boy.getHeight() / 2;
        setupRevealBackground(startingLocation);
//        MainActivity.launch(this, 1);
        sex = 1;
    }


    @OnClick(R.id.girl)
    public void girlClick() {
        int[] startingLocation = new int[2];
        girl.getLocationOnScreen(startingLocation);
        startingLocation[0] += girl.getWidth() / 2;
        startingLocation[1] += girl.getHeight() / 2;
        setupRevealBackground(startingLocation);
//        MainActivity.launch(this, 1);
        sex = 2;
    }

    private void setupRevealBackground(final int []startingLocation) {
        actionBackground.setFillPaintColor(getResources().getColor(R.color.red));
        actionBackground.setOnStateChangeListener(this);
        actionBackground.startFromLocation(startingLocation);
    }

    @Override
    public void onStateChange(int state) {
        if (RevealBackgroundView.STATE_FINISHED == state) {
            MainActivity.launch(this, sex);
            overridePendingTransition(0,0);

        }
    }
}

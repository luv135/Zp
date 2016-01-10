package com.luo.zp.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.luo.zp.R;
import com.luo.zp.fragments.IntroduceFragment;
import com.luo.zp.fragments.SplashFragment;

public class SplashActivity extends AppCompatActivity {

    private Runnable jump;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SplashFragment()).commit();
        }
        jump = new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new IntroduceFragment()).commit();
            }
        };
        handler = new Handler();
        handler.postDelayed(jump, 3000);
//        startActivity(new Intent(this,MainActivity.class));
    }


    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(jump);
    }
}

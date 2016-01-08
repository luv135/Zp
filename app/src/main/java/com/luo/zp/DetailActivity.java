package com.luo.zp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luo.zp.base64.BackAES;
import com.luo.zp.models.MeizhiDetail;
import com.luo.zp.network.MeizhiApi;
import com.luo.zp.network.NetService;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private static final String UID = "UID";
    @Bind(R.id.picture)
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        long uid = getIntent().getLongExtra(UID, 0);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        loadData(uid);
    }

    private void loadData(long uid) {
        String df = null;
        try {
            df = BackAES.encrypt("marriage");
            NetService.getRetrofit().create(MeizhiApi.class)
                    .userInfo(df, uid)
                    .enqueue(new Callback<MeizhiDetail>() {
                        @Override
                        public void onResponse(Response<MeizhiDetail> response) {
                            if (response.isSuccess()) {
                                MeizhiDetail meizhi = response.body();
                                Logger.d("success :%s",meizhi.getEntity().getHeadimage());
                                Glide.with(DetailActivity.this)
                                        .load(meizhi.getEntity().getHeadimage())
                                        .centerCrop()
                                        .into(picture);
                            } else {
                                Logger.d("failure");
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Logger.e(t.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void launch(Activity activity, long uid) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(UID, uid);
        activity.startActivity(intent);

    }
}

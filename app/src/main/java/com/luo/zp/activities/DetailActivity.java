package com.luo.zp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luo.zp.R;
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
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.label)
    LinearLayout label;
    @Bind(R.id.nameTextView)
    TextView nameTextView;
    @Bind(R.id.space)
    View space;
    @Bind(R.id.navigation)
    LinearLayout navigation;
    @Bind(R.id.title)
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        long uid = getIntent().getLongExtra(UID, 0);
        title.setText("心动女生");
        setTitle("");
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
                                MeizhiDetail result = response.body();
                                MeizhiDetail.EntityEntity meizhi = result.getEntity();
                                Logger.d("success :%s", meizhi.getHeadimage());
                                Glide.with(DetailActivity.this)
                                        .load(meizhi.getHeadimage())
                                        .placeholder(R.drawable.detail)
                                        .centerCrop()
                                        .into(picture);
                                nameTextView.setText(String.format("%s %d岁 %s %s", meizhi.getName()
                                        , meizhi.getAge(),
                                        meizhi.getUserinfos().getHomecity(),
                                        meizhi.getUserinfos().getCity()));
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

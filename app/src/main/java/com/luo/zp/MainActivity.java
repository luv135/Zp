package com.luo.zp;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.luo.zp.adapters.MeizhiListAdapter;
import com.luo.zp.adapters.OnMeizhiTouchListener;
import com.luo.zp.base64.BackAES;
import com.luo.zp.models.Meizhi;
import com.luo.zp.models.MeizhiResult;
import com.luo.zp.network.MeizhiApi;
import com.luo.zp.network.NetService;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private MeizhiListAdapter mMeizhiListAdapter;
    private List<Meizhi> mMeizhiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupRecyclerView();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail();
            }
        });
        requestData(1);
    }

    private void detail() {
        OkHttpClient client = new OkHttpClient();
        //version=1.0.0 ，appkey=marriage，app=andorid
//        String url = "http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1";
        String url = "http://120.27.144.185/runlove/app/marriage/user/getRunloveUserinfo?uid=2676958084925440";
//uid = 2676958084925440
        String df;
        try {
//                    encryptResultStr = BackAES.encrypt("marriage", "XIAOYOU1211", 0);
            df = BackAES.encrypt("marriage");
            final Request request = new Request.Builder()
                    .addHeader("version", "1.0.0")
                    .addHeader("appkey", df)
                    .addHeader("app", "android")
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Request request, IOException e) {
                    Logger.e(e.getMessage());
                }

                @Override
                public void onResponse(okhttp3.Response response) throws IOException {
//                    Logger.json(response.body().string());
                    Log.d("TAG",response.body().string());
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void meizi() {
        OkHttpClient client = new OkHttpClient();
        //version=1.0.0 ，appkey=marriage，app=andorid
        String url = "http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1";

        String df;
        try {
//                    encryptResultStr = BackAES.encrypt("marriage", "XIAOYOU1211", 0);
            df = BackAES.encrypt("marriage");
            final Request request = new Request.Builder()
                    .addHeader("version", "1.0.0")
                    .addHeader("appkey", df)
                    .addHeader("app", "android")
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Request request, IOException e) {
                    Logger.e(e.getMessage());
                }

                @Override
                public void onResponse(okhttp3.Response response) throws IOException {
                    Logger.json(response.body().string());
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void setupRecyclerView() {
        final StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mMeizhiListAdapter = new MeizhiListAdapter(this);
        mRecyclerView.setAdapter(mMeizhiListAdapter);

//        mRecyclerView.addOnScrollListener(getOnBottomListener(layoutManager));
        mMeizhiListAdapter.setOnMeizhiTouchListener(getOnMeizhiTouchListener());
    }


    private OnMeizhiTouchListener getOnMeizhiTouchListener() {
        return  new OnMeizhiTouchListener() {
            @Override
            public void onTouch(View v, View meizhiView, View card, Meizhi meizhi) {
                DetailActivity.launch(MainActivity.this,meizhi.getUid());
            }
        };

    }
    private void requestData(@IntRange(from = 1,to = 2) int sex){
        String df = null;
        try {
            df = BackAES.encrypt("marriage");
            NetService.getRetrofit().create(MeizhiApi.class).listMeizhi(df, sex)
                    .enqueue(new retrofit2.Callback<MeizhiResult>() {
                        @Override
                        public void onResponse(Response<MeizhiResult> response) {
                            if (response.isSuccess()) {
                                MeizhiResult body = response.body();
                                mMeizhiListAdapter.add(body.getEntity());
                                Logger.d("meizi size %d", body.getEntity().size());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

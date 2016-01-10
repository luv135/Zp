package com.luo.zp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.luo.zp.R;
import com.luo.zp.base64.BackAES;
import com.luo.zp.models.Meizhi;
import com.luo.zp.models.MeizhiResult;
import com.luo.zp.network.MeizhiApi;
import com.luo.zp.network.NetService;
import com.luo.zp.views.adapters.MeizhiListAdapter;
import com.luo.zp.views.adapters.OnMeizhiTouchListener;
import com.orhanobut.logger.Logger;

import java.io.IOException;

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
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.title)
    TextView title;

    private MeizhiListAdapter mMeizhiListAdapter;

    private int sex;

    public static void launch(Activity activity, @IntRange(from = 1, to = 2) int sex) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra("sex", sex);
//        intent.putExtra("position", startingLocation);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupRecyclerView();
        setTitle("");
        toolbar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                toolbar.getViewTreeObserver().removeOnPreDrawListener(this);


                TranslateAnimation animation = new TranslateAnimation(0, 0, -toolbar.getHeight(), 0);
                animation.setDuration(200);
                toolbar.startAnimation(animation);
//                toolbar.animate.(-toolbar.getHeight());

                return true;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meizi();
//                swipeRefreshLayout.setRefreshing(true);
            }
        });

        sex = getIntent().getIntExtra("sex", 1);
        requestData(sex);
        setRefreshListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        title.setText(String.format("%d/6", count));
    }

    private void picker() {
//        /app/marriage/picked/notlogin/pickedSpouse
        String url = "http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1" +
                "faceid=2677103620638720?touid=2676958084925440";
    }

    private void setRefreshListener() {

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData(sex);
            }
        });
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
                    Log.d("TAG", response.body().string());
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
//        url = "http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1" +
//                "&faceid=2677103620638720";
//        /&touid=2676958084925440
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
//        mRecyclerView.setItemAnimator(new RecyclerAnimator());
        mMeizhiListAdapter = new MeizhiListAdapter(this);
        mRecyclerView.setAdapter(mMeizhiListAdapter);

//        mRecyclerView.addOnScrollListener(getOnBottomListener(layoutManager));
        mMeizhiListAdapter.setOnMeizhiTouchListener(getOnMeizhiTouchListener());
    }


    int count = 0;

    private OnMeizhiTouchListener getOnMeizhiTouchListener() {
        return new OnMeizhiTouchListener() {
            @Override
            public void onTouch(View v, View meizhiView, View card, Meizhi meizhi) {

                if (count++ == 6) {

                    DetailActivity.launch(MainActivity.this, meizhi.getUid());
                    count = 0;
                } else {
                    String faceid = meizhi.getFaceid();

                    Logger.d("click: position is : %d", mMeizhiListAdapter.findFaceidPosition(faceid, mMeizhiListAdapter.getList()));
                    int itemCount = mMeizhiListAdapter.getItemCount();
                    Meizhi item = mMeizhiListAdapter.getItem(itemCount - 1);
                    long uid = item.getUid();
                    Logger.d("faceid: %s  uid: %d", faceid, uid);
                    refreshData(sex, faceid, uid);
                }
                title.setText(String.format("%d/6",count));
            }
        };

    }

    private void refreshData(int sex, final String faceid, long uid) {
        swipeRefreshLayout.setRefreshing(true);
        String df = null;
        try {
            df = BackAES.encrypt("marriage");
            NetService.getRetrofit().create(MeizhiApi.class).update(df, sex, faceid, uid)
                    .enqueue(new retrofit2.Callback<MeizhiResult>() {
                        @Override
                        public void onResponse(Response<MeizhiResult> response) {
                            if (response.isSuccess()) {
                                MeizhiResult body = response.body();
                                mMeizhiListAdapter.update(faceid, body.getEntity());
                                Logger.d("meizi size %d", body.getEntity().size());
                            } else {
                                Logger.d("failure");
                            }
                            swipeRefreshLayout.setRefreshing(false);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Logger.e(t.getMessage());
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void requestData(@IntRange(from = 1, to = 2) int sex) {
        String df = null;
        swipeRefreshLayout.setRefreshing(true);
        try {
            df = BackAES.encrypt("marriage");
            NetService.getRetrofit().create(MeizhiApi.class).listMeizhi(df, sex)
                    .enqueue(new retrofit2.Callback<MeizhiResult>() {
                        @Override
                        public void onResponse(Response<MeizhiResult> response) {

                            if (response.isSuccess()) {
                                MeizhiResult body = response.body();
                                mMeizhiListAdapter.update(null, body.getEntity());
                                Logger.d("meizi size %d", body.getEntity().size());
                            } else {
                                Logger.d("failure");
                            }
                            swipeRefreshLayout.setRefreshing(false);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Logger.e(t.getMessage());
                            swipeRefreshLayout.setRefreshing(false);
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

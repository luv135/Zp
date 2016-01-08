package com.luo.zp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    presenter = new MainPresenter();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loaddata();
            }
        });
    }
    private void setupRecyclerView() {
//        final StaggeredGridLayoutManager layoutManager
//                = new StaggeredGridLayoutManager(2,
//                StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mMeizhiListAdapter = new MeizhiListAdapter(this, mMeizhiList);
//        mRecyclerView.setAdapter(mMeizhiListAdapter);
//        new Once(this).show("tip_guide_6", () -> {
//            Snackbar.make(mRecyclerView, getString(R.string.tip_guide),
//                    Snackbar.LENGTH_INDEFINITE)
//                    .setAction(R.string.i_know, v -> {
//                    })
//                    .show();
//        });
//
//        mRecyclerView.addOnScrollListener(getOnBottomListener(layoutManager));
//        mMeizhiListAdapter.setOnMeizhiTouchListener(getOnMeizhiTouchListener());
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

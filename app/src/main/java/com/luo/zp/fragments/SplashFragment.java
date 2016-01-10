package com.luo.zp.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luo.zp.R;
import com.luo.zp.base64.BackAES;
import com.luo.zp.network.NetService;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.annotation.ElementType;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class SplashFragment extends Fragment {

    @Bind(R.id.imageView)
    ImageView imageView;
    private Call call;

    public SplashFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spalsh, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        getObservable().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<byte[]>() {
//                    @Override
//                    public void call(byte[] bytes) {
//                        Logger.d("success"+bytes.length);
//                        load(bytes);
//                    }
//
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.d("error");
//                    }
//                });


    }

//    @NonNull
//    private Observable<byte[]> getObservable() {
//        return Observable.create(new Observable.OnSubscribe<byte[]>() {
//            @Override
//            public void call(Subscriber<? super byte[]> subscriber) {
//                OkHttpClient client = NetService.getOkHttpClient();
//                String df;
//                try {
//                    df = BackAES.encrypt("marriage");
//                    String url = "http://120.27.144.185/runlove/app/marriage/base/getScreenAdvert";
//                    final Request request = new Request.Builder()
//                            .addHeader("version", "1.0.0")
//                            .addHeader("appkey", df)
//                            .addHeader("app", "android")
//                            .url(url)
//                            .build();
//                    call = client.newCall(request);
//                    Response response = call.execute();
//                    if (response.isSuccessful()) {
//                        Logger.d(response.body().string());
//                        subscriber.onNext(response.body().bytes());
//                        subscriber.onCompleted();
//                    } else {
//                        subscriber.onError(null);
//                    }
//
//                } catch (Exception e1) {
////                    e1.printStackTrace();
//                    subscriber.onError(e1);
//                }
//
//            }
//        });
//    }

//
//    public void load(byte[] bytes) {
//        Glide.with(this).load(bytes).into(imageView);
//
//    }

    @Override
    public void onPause() {
        super.onPause();
//        call.cancel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

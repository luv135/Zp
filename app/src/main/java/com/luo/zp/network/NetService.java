package com.luo.zp.network;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Luo on 2016/1/8.
 */
public class NetService {

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static void init(){
        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://120.27.144.185/runlove/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

package com.luo.zp;

import com.luo.zp.base64.BackAES;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Luo on 2016/1/8.
 */
public class MainPresenter {

    public void loaddata(){
        OkHttpClient client = new OkHttpClient();
        //version=1.0.0 ，appkey=marriage，app=andorid
        String url = "http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1";

        String df;
        try {
//                    encryptResultStr = BackAES.encrypt("marriage", "XIAOYOU1211", 0);
            df = BackAES.encrypt("marriage");
            Request request = new Request.Builder()
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
                public void onResponse(Response response) throws IOException {
                    Logger.d(response.body().string());
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}

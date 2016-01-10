package com.luo.zp.network;

import com.luo.zp.models.Meizhi;
import com.luo.zp.models.MeizhiDetail;
import com.luo.zp.models.MeizhiResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Luo on 2016/1/8.
 */
public interface MeizhiApi {
    @Headers({
            "version:1.0.0",
            "app:android"
    })
//    @FormUrlEncoded
    @GET("app/marriage/picked/notlogin/pickedSpouse")
    Call<MeizhiResult> listMeizhi(@Header("appkey") String marriage,
                                  @Query("sex") int sex
                                  /*,@Field("sex") int sex*/);

    @Headers({
            "version:1.0.0",
            "app:android"
    })
    @GET("app/marriage/user/getRunloveUserinfo")
    Call<MeizhiDetail> userInfo(@Header("appkey") String marriage,
                                @Query("uid") long uid);

    //http://120.27.144.185/runlove/app/marriage/picked/notlogin/pickedSpouse?sex=1&faceid=35158cf1f0abb3d1f2e47ee3697ad608&touid=2676958084925440
    @Headers({
            "version:1.0.0",
            "app:android"
    })
    @GET("app/marriage/picked/notlogin/pickedSpouse")
    Call<MeizhiResult> update(@Header("appkey") String marriage,
                              @Query("sex") int sex,
                              @Query("faceid")String faceid,
                              @Query("touid")long uid);
}

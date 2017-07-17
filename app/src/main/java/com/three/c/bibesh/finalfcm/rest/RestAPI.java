package com.three.c.bibesh.finalfcm.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Bibesh on 7/17/17.
 */

public interface RestAPI {
    @POST("fcm/save.php")
    @FormUrlEncoded
    Call<Void> sendToken(@Field("token") String token);
}

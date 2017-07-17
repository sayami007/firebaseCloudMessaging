package com.three.c.bibesh.finalfcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.three.c.bibesh.finalfcm.rest.RestAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public String url = "http://192.168.0.101/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit fit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RestAPI api = fit.create(RestAPI.class);
        Call<Void> call = api.sendToken(FirebaseInstanceId.getInstance().getToken());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.v("Success", "" + true);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Success", "" + false);
                Log.v("RES", "" + t.getMessage());

            }
        });
    }
}

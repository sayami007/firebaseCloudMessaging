package com.three.c.bibesh.finalfcm.services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Bibesh on 7/17/17.
 */

public class MyFBInstance extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        sendToken(token);
    }

    private void sendToken(String token) {


    }
}

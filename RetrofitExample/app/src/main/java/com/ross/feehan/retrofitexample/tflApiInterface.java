package com.ross.feehan.retrofitexample;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public interface tflApiInterface {

    @GET("/line/mode/tube/status")
    public void getTubeStatus(Callback<Tube> callback);

}

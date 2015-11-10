package com.ross.feehan.retrofitexample.Interfaces;

import com.ross.feehan.retrofitexample.Objects.Tube;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public interface TflApiInterface {

    @GET("/line/mode/tube/status")
    public void getTubeStatus(Callback<List<Tube>> callback);

    //Usually you would use Callback<Type> callback
    //But in this case the json returned from the api starts with a json array
    //so you have to notify Retrofit to accept a list rather than object as usual.

}

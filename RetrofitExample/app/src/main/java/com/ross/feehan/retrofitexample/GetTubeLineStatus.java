package com.ross.feehan.retrofitexample;

import com.ross.feehan.retrofitexample.Interfaces.GetTubeLineServiceViewInterface;
import com.ross.feehan.retrofitexample.Interfaces.GetTubeLineStatusInterface;
import com.ross.feehan.retrofitexample.Interfaces.TflApiInterface;
import com.ross.feehan.retrofitexample.Objects.TubeLines;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public class GetTubeLineStatus implements GetTubeLineStatusInterface {

    private GetTubeLineServiceViewInterface tubeViewListener;
    private static final String API_URL = "https://api.tfl.gov.uk";
    private TflApiInterface tflApiInterface;
    private Callback retrofitCallback;
    private static final String NETWORKERROR = "NETWORK";

    @Override
    public void getTubeStatus(GetTubeLineServiceViewInterface tubeViewListener) {
        this.tubeViewListener = tubeViewListener;

        setupRetrofit();

        //Make the api call, we use a callback so the api call will be async
        tflApiInterface.getTubeLineStatus(retrofitCallback);
    }

    /*
    * Method to get Retrofit ready so the api calls can be made
    */
    private void setupRetrofit(){
        //set up the rest adapter and the methods it can call
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        //set up the interface to access the api calls
        tflApiInterface = restAdapter.create(TflApiInterface.class);

        //set up the retrofitCallback for when retrofit has finished communicating with the api
        retrofitCallback = setUpCallback();
    }

    /*Method that sets up the callback to be sent with the retrofit api request
    *Called when retrofit has finished communicating with api
    *The returned values from retrofit are returned to the calling class here
    */
    public Callback setUpCallback(){
        Callback callback = new Callback(){

            @Override
            public void success(Object o, Response response) {
                //Send the list of tube states back to the calling class
                List<TubeLines> tubeStates = (List<TubeLines>) o;
                tubeViewListener.displayTubeLineStates(tubeStates);
            }

            @Override
            public void failure(RetrofitError error) {
               //Notify the calling class if there was a networking error
                if(error.getKind().equals(NETWORKERROR)){
                    tubeViewListener.noInternetConnection();
                }
                else{
                    //Notify the calling class that there was an error
                    tubeViewListener.somethingWentWrong(error.getMessage().toString());
                }
            }
        };
        return callback;
    }
}
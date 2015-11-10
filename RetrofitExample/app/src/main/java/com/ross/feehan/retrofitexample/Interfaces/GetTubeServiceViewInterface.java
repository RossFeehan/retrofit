package com.ross.feehan.retrofitexample.Interfaces;

import com.ross.feehan.retrofitexample.Objects.Tube;

import java.util.List;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public interface GetTubeServiceViewInterface {

    public void noInternetConnection();

    public void somethingWentWrong();

    public void displayTubeLineStates(List<Tube> tubeStates);
}

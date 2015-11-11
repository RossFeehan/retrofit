package com.ross.feehan.retrofitexample.Interfaces;

import com.ross.feehan.retrofitexample.Objects.TubeLines;

import java.util.List;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public interface GetTubeLineServiceViewInterface {

    public void noInternetConnection();

    public void somethingWentWrong(String message);

    public void displayTubeLineStates(List<TubeLines> tubeStates);
}

package com.ross.feehan.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public class TubeLineStatus {

    @SerializedName("statusSeverityDescription")private String tubeLineStatus;

    //CONSTRUCTOR
    public TubeLineStatus(String status){
        setTubeLineStatus(status);
    }

    //SETTERS
    public void setTubeLineStatus(String tubeLineStatus) {
        this.tubeLineStatus = tubeLineStatus;
    }

    //GETTERS
    public String getTubeLineStatus() {
        return tubeLineStatus;
    }




}

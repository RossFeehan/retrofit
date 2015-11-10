package com.ross.feehan.retrofitexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public class Tube {

    @SerializedName("name") private String tubeName;
    private TubeLineStatus tubeStatus;

    //CONSTRUCTOR
    public Tube(String tubeName, TubeLineStatus status){
        setTubeName(tubeName);
        setTubeStatus(status);
    }

    //SETTERS
    public void setTubeName(String tubeName) {
        this.tubeName = tubeName;
    }

    public void setTubeStatus(TubeLineStatus tubeStatus) {
        this.tubeStatus = tubeStatus;
    }

    //GETTERS
    public String getTubeName() {
        return tubeName;
    }

    public TubeLineStatus getTubeStatus() {
        return tubeStatus;
    }
}

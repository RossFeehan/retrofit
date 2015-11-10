package com.ross.feehan.retrofitexample.Objects;

import com.google.gson.annotations.SerializedName;
import com.ross.feehan.retrofitexample.Objects.TubeLineStatus;

import java.util.List;

/**
 * Created by Ross Feehan on 10/11/2015.
 * Copyright Ross Feehan
 */
public class Tube {

    @SerializedName("name") private String tubeName;
    @SerializedName("lineStatuses") private List<TubeLineStatus> tubeStatus;

    //CONSTRUCTOR
    public Tube(String tubeName, List<TubeLineStatus> status){
        setTubeName(tubeName);
        setTubeStatus(status);
    }

    //SETTERS
    public void setTubeName(String tubeName) {
        this.tubeName = tubeName;
    }

    public void setTubeStatus(List<TubeLineStatus> tubeStatus) {
        this.tubeStatus = tubeStatus;
    }

    //GETTERS
    public String getTubeName() {
        return tubeName;
    }

    public List<TubeLineStatus> getTubeStatus() {
        return tubeStatus;
    }

}

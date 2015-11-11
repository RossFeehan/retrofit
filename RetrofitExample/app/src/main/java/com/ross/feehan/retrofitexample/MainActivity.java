package com.ross.feehan.retrofitexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ross.feehan.retrofitexample.Interfaces.GetTubeLineServiceViewInterface;
import com.ross.feehan.retrofitexample.Objects.TubeLines;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements GetTubeLineServiceViewInterface {

    @Bind(R.id.tubeRV) RecyclerView tubeLinesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FOR BUTTERKNIFE
        ButterKnife.bind(this);

        GetTubeLineStatus getTubeStatus = new GetTubeLineStatus();
        getTubeStatus.getTubeStatus(this);
    }

    //GetTubeServiceViewInterface INTERFACE METHODS
    @Override
    public void noInternetConnection() {
        Toast.makeText(this, "Sorry, no internet connection", Toast.LENGTH_LONG).show();
    }

    @Override
    public void somethingWentWrong(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayTubeLineStates(List<TubeLines> tubeStates) {
        //Creating the layout of the recycler view (linearlayout creates a list view)
        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        tubeLinesRV.setLayoutManager(recyclerViewLayoutManager);

        //Creating the adapter for the recycler view, loaded with the tube lines
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(tubeStates);
        tubeLinesRV.setAdapter(recyclerViewAdapter);

    }
}

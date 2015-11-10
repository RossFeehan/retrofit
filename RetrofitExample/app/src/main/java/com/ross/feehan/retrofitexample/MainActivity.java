package com.ross.feehan.retrofitexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ross.feehan.retrofitexample.Interfaces.GetTubeServiceViewInterface;
import com.ross.feehan.retrofitexample.Objects.Tube;

import java.util.List;

public class MainActivity extends Activity implements GetTubeServiceViewInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetTubeStatus getTubeStatus = new GetTubeStatus();

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
    public void displayTubeLineStates(List<Tube> tubeStates) {
        Toast.makeText(this, "Display tube states", Toast.LENGTH_LONG).show();
    }
}

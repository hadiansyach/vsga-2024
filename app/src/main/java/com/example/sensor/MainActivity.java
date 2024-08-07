package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        TextView tvListSensor = findViewById(R.id.tvListSensor);

        for (Sensor sensor : sensorList) {
            tvListSensor.append(sensor.getName() + "\n");
        }

        Sensor sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        TextView tvLightSensor = findViewById(R.id.tvLightSensor);
        tvLightSensor.setText(sensor1 == null ? "There isn't any sensor" : sensor1.getName() + "\n" + sensor1.getPower() + " mW");
    }
}
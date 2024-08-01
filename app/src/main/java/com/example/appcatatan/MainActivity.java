package com.example.appcatatan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        mainAdapter = new MainAdapter(this);
        listView.setAdapter(mainAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainAdapter.clear();
        mainAdapter.addAll(getCatatan());
    }

    private ArrayList<Catatan> getCatatan() {
        ArrayList<Catatan> catatan = new ArrayList<>();

        File directory = new File(getFilesDir(), "/catatan");
        if (directory == null) return catatan;

        File[] files = directory.listFiles();
        if (files == null) return catatan;

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        for (File file : files) {
            String fileName = file.getName();
            Date date = new Date(file.lastModified());
            String timestamp = formatter.format(date);

            catatan.add(new Catatan(fileName, timestamp));
        }
        return catatan;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_menu) {
            Intent i = new Intent(this, TambahActivity.class);
            startActivity(i);
            return true;
        }
        return false;
    }
}
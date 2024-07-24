package com.example.inputnama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vsga.hadiansyach.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] countries = new String[]{"Indonesia", "Malaysia", "Singapura", "Thailand", "Vietnam", "Filipina", "Brunei Darussalam", "Arab Saudi", "Korea Selatan", "Jepang", "Jerman", "Australia", "Nepal", "Kroasia", "Spanyol", "Sri Lanka", "France", "Italia", "Slovakia", "Slovenia", "Kuba"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewCountries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, countries);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(this, countries[position] + " clicked", Toast.LENGTH_SHORT).show());
    }
}
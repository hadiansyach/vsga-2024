package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText etNama;
    private EditText etAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        databaseHelper = new DatabaseHelper(this);

        etNama = (EditText) findViewById(R.id.etNama);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        Button btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        Button btnCancel = (Button) findViewById(R.id.buttonCancels);

        btnSubmit.setOnClickListener(v -> {
            String name = etNama.getText().toString();
            String address = etAlamat.getText().toString();

            if (name.isEmpty() && address.isEmpty()) {
                Toast.makeText(this, "Nama dan Alamat tidak boleh kosong", Toast.LENGTH_LONG).show();

            } else {
                databaseHelper.addContact(name, address);
            }
        });
        btnCancel.setOnClickListener(v -> {
            etNama.getText().clear();
            etAlamat.getText().clear();
            databaseHelper.getAllContacts();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
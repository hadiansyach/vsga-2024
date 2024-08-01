package com.example.appcatatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class TambahActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText noteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        nameEditText = findViewById(R.id.etFileName);
        noteEditText = findViewById(R.id.etEditNote);
    }

    public void save(View view) {
        String fileName = nameEditText.getText().toString();
        if (fileName.isEmpty()) {
            Toast.makeText(this, "Nama File Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
            return;
        }

        String note = noteEditText.getText().toString();
        if (note.isEmpty()) {
            Toast.makeText(this, "Isi Catatan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        makeFile(fileName, note);
        finish();
    }

    public void makeFile(String fileName, String note) {
        File directory = new File(getFilesDir(), "/catatan");

        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File(getFilesDir() + "/catatan/" + fileName + ".txt");
        FileOutputStream fos;

        try {
            file.createNewFile();
            fos = new FileOutputStream(file, false);
            fos.write(note.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
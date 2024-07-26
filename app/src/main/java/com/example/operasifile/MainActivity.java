package com.example.operasifile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;


public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "catatan.txt";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etFile);
        readFile();
    }

    private void makeFile() {
        File file = new File(getFilesDir(), FILENAME);
        FileOutputStream fos;
        try {
            file.createNewFile();
            fos = new FileOutputStream(file, false);
            fos.write(editText.getText().toString().getBytes());
            fos.flush();
            fos.close();
            Log.d("SAVE FILE", "makeFile: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            editText.setText(text.toString());
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteFile() {
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()) {
            file.delete();
            Toast.makeText(this, "File Berhasil Dihapus;", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnMakeFile) {
            makeFile();
        } else if (view.getId() == R.id.btnReadFile) {
            readFile();
        } else if (view.getId() == R.id.btnDeleteFile) {
            deleteFile();

        }
    }
}
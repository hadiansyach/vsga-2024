package com.example.appcatatan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainAdapter extends ArrayAdapter<Catatan> {

    public MainAdapter(@NonNull Context context) {
        super(context, 0, new ArrayList<>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Catatan catatan = getItem(position);

        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(catatan.getFileName());
        TextView textView2 = view.findViewById(android.R.id.text2);
        textView2.setText(catatan.getTimestamp());

        return view;
    }
}

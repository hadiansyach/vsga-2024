package com.example.sqlite.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final ArrayList<String> allContacts;

    public ContactAdapter(ArrayList<String> list) {
        this.allContacts = list;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        String contact = allContacts.get(position);
        String[] parts = contact.split(", Address: ");

        String name = parts[0].replace("Name: ", "");
        String address = parts[1];

        holder.tvContactName.setText(name);
        holder.tvContactAddress.setText(address);

        holder.itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), name + " Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return allContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvContactName;
        public TextView tvContactAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContactName = itemView.findViewById(R.id.tvContactName);
            tvContactAddress = itemView.findViewById(R.id.tvContactAddress);
        }
    }
}

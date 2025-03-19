package com.devdroid.emergency2;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.ViewHolder> {

    private List<EmergencyContact> contactList;
    private Context context;

    public EmergencyAdapter(List<EmergencyContact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emergency_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmergencyContact contact = contactList.get(position);
        holder.contactName.setText(contact.getName());

        holder.callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView contactName;
        Button callButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            callButton = itemView.findViewById(R.id.callButton);
        }
    }
}
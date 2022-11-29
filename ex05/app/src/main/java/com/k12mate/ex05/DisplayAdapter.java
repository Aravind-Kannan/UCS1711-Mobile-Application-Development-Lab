package com.k12mate.ex05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder>{
    private ArrayList<PersonModel> Persons;
    private Context context;

    public DisplayAdapter(ArrayList<PersonModel> Persons, Context context) {
        this.Persons = Persons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_info_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonModel person = Persons.get(position);
        holder.id.setText("ID: " + String.valueOf(person.getId()));
        holder.name.setText("Name: " + person.getName());
        holder.country.setText("Country: " + person.getCountry());
        holder.phone.setText("Phone: " + person.getPhone());
        holder.email.setText("Email: " + person.getEmail());
    }

    @Override
    public int getItemCount() {
        return Persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id, name, country, phone, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id2);
            name = itemView.findViewById(R.id.name2);
            country = itemView.findViewById(R.id.country2);
            phone = itemView.findViewById(R.id.phone2);
            email = itemView.findViewById(R.id.email2);
        }
    }
}
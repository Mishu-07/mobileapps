package com.example.lms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> bookid, bookname, author, category;
    private ArrayList<Integer> available;

    CustomAdapter(Context context, ArrayList<String> bookid, ArrayList<String> bookname, ArrayList<String> author, ArrayList<String> category, ArrayList<Integer> available) {
        this.context = context;
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.category = category;
        this.available = available;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.bookid.setText(bookid.get(position));
        holder.bookname.setText(bookname.get(position));
        holder.author.setText(author.get(position));
        holder.category.setText(category.get(position));
        holder.available.setText(String.valueOf(available.get(position))); // No need for String.valueOf() as available is already a String
    }

    @Override
    public int getItemCount() {
        return bookid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bookid, bookname, author, category, available;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookid = itemView.findViewById(R.id.bookid);
            bookname = itemView.findViewById(R.id.bookname);
            author = itemView.findViewById(R.id.bookAuthor);
            category = itemView.findViewById(R.id.category);
            available = itemView.findViewById(R.id.bookStock);
        }
    }
}
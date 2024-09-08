package com.example.lms;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Database db;
    ArrayList<String> bookid, bookname, author, category;
    ArrayList<Integer> available;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = new Database(getApplicationContext(), "bookmanager", null, 1); // Changed database name
        bookid = new ArrayList<>();
        bookname = new ArrayList<>();
        author = new ArrayList<>();
        category = new ArrayList<>();
        available = new ArrayList<>();

        displayData();
        customAdapter = new CustomAdapter(BookViewActivity.this, bookid, bookname, author, category, available);
        recyclerView = findViewById(R.id.recyclerViewBook);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BookViewActivity.this));
    }

    void displayData() {
        Cursor cursor = db.getBooks();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                bookid.add(cursor.getString(0));
                bookname.add(cursor.getString(1));
                author.add(cursor.getString(2));
                category.add(cursor.getString(3));
                available.add(Integer.valueOf(String.valueOf(cursor.getInt(4)))); // Retrieve available as integer and convert to String
            }
            cursor.close(); // Close the cursor after use
        }
    }
}
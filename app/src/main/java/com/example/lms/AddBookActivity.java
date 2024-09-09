package com.example.lms;

import android.content.Intent;
import android.os.Bundle;import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Category DropDown
        final String[] selectedCat = {""};
        String[] list = getResources().getStringArray(R.array.BookCategory);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.category_list, list);
        AutoCompleteTextView autocompleteTV = findViewById(R.id.CatagoryDropDown);
        autocompleteTV.setAdapter(arrayAdapter);
        autocompleteTV.setOnItemClickListener((parent, view, position, id) ->
                selectedCat[0] = (String) parent.getItemAtPosition(position));

        findViewById(R.id.cancelBookBtn).setOnClickListener(view ->
                startActivity(new Intent(AddBookActivity.this, AdminPanelActivity.class)));

        EditText bookName = findViewById(R.id.editTextBookName);
        EditText author = findViewById(R.id.editTextAuthor);
        EditText bookId = findViewById(R.id.editTextBookId);
        EditText availableStock = findViewById(R.id.editTextAvailableStock);

        findViewById(R.id.addBookBtn).setOnClickListener(view -> {
            String b_name = bookName.getText().toString();
            String b_author = author.getText().toString();
            String b_id = bookId.getText().toString();
            String b_stock = availableStock.getText().toString();
            String b_cat = selectedCat[0];
            Database db = new Database(getApplicationContext(), "bookmanager", null, 1);
            if (b_name.isEmpty() || b_id.isEmpty() || b_author.isEmpty() || b_stock.isEmpty()|| b_cat.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Fields cannot be empty! Please fill properly.", Toast.LENGTH_LONG).show();
            } else {
                try {
                    db.addBook(b_id, b_name, b_author, b_cat, b_stock);
                    Toast.makeText(getApplicationContext(), "Book added successfully!", Toast.LENGTH_LONG).show();
                    // You might want to clear the fields or navigate to another activity after adding the book
                    bookName.setText("");
                    author.setText("");
                    bookId.setText("");
                    availableStock.setText("");
                    autocompleteTV.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid stock value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
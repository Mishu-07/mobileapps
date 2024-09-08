package com.example.lms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_panel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("sname","");
        Toast.makeText(getApplicationContext(),"Welcome, "+username+"!",Toast.LENGTH_SHORT).show();

    CardView list = findViewById(R.id.adminUpdate);
    list.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AdminPanelActivity.this, BookViewActivity.class));
        }
    });
    CardView addbook = findViewById(R.id.adminAddBook);
    addbook.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AdminPanelActivity.this, AddBookActivity.class));
        }
    });

        CardView exit = findViewById(R.id.adminLogout);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(AdminPanelActivity.this, LoginActivity.class));
        });

        findViewById(R.id.adminAddRole).setOnClickListener(view ->{
            startActivity(new Intent(AdminPanelActivity.this, AddAdminActivity.class));
        });

        findViewById(R.id.adminAboutUs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminPanelActivity.this, AboutUsActivity.class));
            }
        });

        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {private long backPressedTime = 0;
            @Override
            public void handleOnBackPressed() {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    finishAffinity();
                    return;
                } else {
                    Toast.makeText(AdminPanelActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();
                }
                backPressedTime = System.currentTimeMillis();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }
}
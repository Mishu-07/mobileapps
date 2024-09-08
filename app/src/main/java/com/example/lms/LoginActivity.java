package com.example.lms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edStd_id, edPass;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edStd_id = findViewById(R.id.editTextLoginId);
        edPass = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.loginButton);
        tv = findViewById(R.id.regtext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid=edStd_id.getText().toString();
                String pass=edPass.getText().toString();
                String username = "";
                Database db = new Database(getApplicationContext(),"librarymanager", null, 1);

                if(sid.length()==0 || pass.length()==0){
                    Toast.makeText(getApplicationContext(),"ID or password cannot be empty!", Toast.LENGTH_LONG).show();
                }
                else
                    if(db.login(sid,pass)==1){
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("sid", sid);
                        username = db.getUsername(sid); // Fetch username from database
                        editor.putString("sname",username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }
                    else if(db.login(sid,pass)==2){
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("sid", sid);
                        username = db.getUsername(sid); // Fetch username from database
                        editor.putString("sname",username);
                        // to save our data with key and value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,AdminPanelActivity.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid Id or password. Try again!", Toast.LENGTH_LONG).show();
                    }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {private long backPressedTime = 0;
            @Override
            public void handleOnBackPressed() {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    finishAffinity();
                    return;
                } else {
                    Toast.makeText(LoginActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();
                }
                backPressedTime = System.currentTimeMillis();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }
}
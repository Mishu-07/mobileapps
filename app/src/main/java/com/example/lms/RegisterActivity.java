package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText edSname, edSid, edSmail, edSPass, edSCpass;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edSname = findViewById(R.id.editTextRegUserName);
        edSid = findViewById(R.id.editTextRegStdID);
        edSmail = findViewById(R.id.editTextRegEmail);
        edSPass = findViewById(R.id.editTextRegPass);
        edSCpass = findViewById(R.id.editTextRegCPass);
        btn = findViewById(R.id.RegButton);
        tv = findViewById(R.id.RegiText);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=edSname.getText().toString();
                String stid=edSid.getText().toString();
                String smail=edSmail.getText().toString();
                String pass=edSPass.getText().toString();
                String cpass=edSCpass.getText().toString();
                String role="user";
                Database db = new Database(getApplicationContext(),"librarymanager", null, 1);
                if(sname.length()==0 || stid.length()==0 || smail.length()==0 || pass.length()==0 || cpass.length()==0){
                    Toast.makeText(getApplicationContext(),"Fields cannot be empty! Please fill properly.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(pass.compareTo(cpass)==0){
                        db.register(sname,stid,smail,pass, role);
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Passwords didn't match.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
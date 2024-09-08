package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddAdminActivity extends AppCompatActivity {

    EditText AdminName, AdminEmail, AdminPass, AdminCPass, AdminId;
    Button AddAdmin, CancelAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AdminName = findViewById(R.id.editTextAdminName);
        AdminEmail = findViewById(R.id.editTextAdminEmail);
        AdminPass = findViewById(R.id.editTextAdminPass);
        AdminCPass = findViewById(R.id.editTextAdminCpass);
        AdminId = findViewById(R.id.editTextAdminId);
        AddAdmin = findViewById(R.id.AddAdminButton);
        CancelAdmin = findViewById(R.id.AddAdminCancelButton);

        AddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=AdminName.getText().toString();
                String stid=AdminId.getText().toString();
                String smail=AdminEmail.getText().toString();
                String pass=AdminPass.getText().toString();
                String cpass=AdminCPass.getText().toString();
                String role="admin";
                Database db = new Database(getApplicationContext(),"librarymanager", null, 1);
                if(sname.length()==0 || stid.length()==0 || smail.length()==0 || pass.length()==0 || cpass.length()==0){
                    Toast.makeText(getApplicationContext(),"Fields cannot be empty! Please fill properly.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(pass.compareTo(cpass)==0){
                        db.register(sname,stid,smail,pass, role);
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG).show();
                        AdminName.setText("");
                        AdminId.setText("");
                        AdminEmail.setText("");
                        AdminPass.setText("");
                        AdminCPass.setText("");
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Passwords didn't match.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        CancelAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddAdminActivity.this, AdminPanelActivity.class));
            }
        });
    }
}
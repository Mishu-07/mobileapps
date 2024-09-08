package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CatalogueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catelogue);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CardView cse = findViewById(R.id.cardCSE);
        cse.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Computer Science & Engineering");
            startActivity(it);
        });
        CardView civil = findViewById(R.id.cardCivil);
                civil.setOnClickListener(view -> {
                    Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
                    it.putExtra("title", "Civil Engineering");
                    startActivity(it);
                });
        CardView eee = findViewById(R.id.cardEEE);
        eee.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Electrical & Electronics Engineering");
            startActivity(it);
        });
        CardView mech = findViewById(R.id.cardMechanical);
        mech.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Mechanical Engineering");
            startActivity(it);
        });
        CardView textile = findViewById(R.id.cardTextile);
        textile.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Textile Engineering");
            startActivity(it);
        });
        CardView arch = findViewById(R.id.cardArch);
        arch.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Architecture Engineering");
            startActivity(it);
        });
        CardView phy = findViewById(R.id.cardPhysics);
        phy.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Physics");
            startActivity(it);
        });
        CardView chem = findViewById(R.id.cardChem);
        chem.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Chemistry");
            startActivity(it);
        });
        CardView math = findViewById(R.id.cardMath);
        math.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "math");
            startActivity(it);
        });
        CardView other = findViewById(R.id.cardOthers);
        other.setOnClickListener(view -> {
            Intent it = new Intent(CatalogueActivity.this, BookDetailsActivity.class);
            it.putExtra("title", "Others book");
            startActivity(it);
        });
    }
}
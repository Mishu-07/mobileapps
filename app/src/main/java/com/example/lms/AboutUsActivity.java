package com.example.lms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutUsActivity extends AppCompatActivity {

    ImageView facebookMishu, instagramMishu, wpMishu, tgMishu, facebookHira, instaHira, wpHira, tgHira, emailMishu, emailHira;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       facebookMishu = findViewById(R.id.facebookMishu);
       instagramMishu = findViewById(R.id.instaMishu);
       wpMishu = findViewById(R.id.whatsappMishu);
       tgMishu = findViewById(R.id.telegramMishu);
       facebookHira = findViewById(R.id.facebookhira);
       instaHira = findViewById(R.id.instaHira);
       wpHira = findViewById(R.id.whatsappHira);
       tgHira = findViewById(R.id.telegramHira);
       emailMishu = findViewById(R.id.emailMishu);
       emailHira = findViewById(R.id.emailHira);

       facebookMishu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String url ="https://facebook.com/Mishu7.Shra";
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
               startActivity(intent);
           }
       });
       facebookHira.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String url ="https://facebook.com/harunhira.m9";
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
               startActivity(intent);
           }
       });
        instagramMishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://instagram.com/mishu_saeed";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        instaHira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://instagram.com/mdharun.hira";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        wpMishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://wa.me/+8801680436741";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        wpHira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://wa.me/+8801779525408";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        tgMishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://t.me/Mishu07_S";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
            });
        tgHira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://t.me/+8801779525408";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
            });
        emailMishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("text/plain");
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"misho.saeed16@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Library Management System");
                i.putExtra(Intent.EXTRA_TEXT, "Hi there,");
                i.setPackage("com.google.android.gm");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        emailHira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("text/plain");
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"harunhira675@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Library Management System");
                i.putExtra(Intent.EXTRA_TEXT, "Hi there,");
                i.setPackage("com.google.android.gm");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
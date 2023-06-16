package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aboutme.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Button link_btn = binding.linkedinBtn;
        Button what_btn = binding.whatBtn;
        EditText message_text = binding.messageText;
        Button email_btn = binding.emailBtn;

        email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = message_text.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "pierrequintero@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "@string/subject");
                intent.putExtra(Intent.EXTRA_TEXT, message);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        what_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "+56971978769";
                String whatsappUrl = "https://api.whatsapp.com/send?phone=" + phoneNumber;

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(whatsappUrl));
                startActivity(intent);
            }
        });

        link_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkedinProfileId = "pierre-quintero";
                String linkedinAppUrl = "linkedin://profile/" + linkedinProfileId;

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinAppUrl));
                    intent.setPackage("com.linkedin.android");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    String linkedinWebUrl = "https://www.linkedin.com/in/pierre-quintero";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinWebUrl));
                    startActivity(intent);
                }
            }
        });
    }
}
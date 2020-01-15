package com.example.talkingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String name = getIntent().getStringExtra("name");
        String content = getIntent().getStringExtra("content");
        AppCompatTextView textContent = findViewById(R.id.content);
        AppCompatTextView textName = findViewById(R.id.name);
        textContent.setText("内容: "+content);
        textName.setText("昵称: "+name);
    }
}

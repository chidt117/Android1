package com.example.talkingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.menuItem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SendActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (SendActivity.talkList == null) {
            SendActivity.talkList = new ArrayList<>();
        }
        mainAdapter = new MainAdapter(this,SendActivity.talkList);
        recyclerView.setAdapter(mainAdapter);
    }

    public void jump(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SendActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SendActivity.talkList!=null) {
            for (int i = 0;i < SendActivity.talkList.size();i++){
                System.out.println(SendActivity.talkList.get(i));
            }
            mainAdapter.notifyDataSetChanged();
        }
    }
}

package com.example.talkingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SendActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private AppCompatEditText editText;
    private AppCompatEditText editName;
    private ChatAdapter chatAdapter;
    public static List<Talk> talkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        initView();
        initAdapter();
    }

    private void initView() {
        editText = findViewById(R.id.editText);
        recycler_view = findViewById(R.id.recycler_view);
        editName = findViewById(R.id.editName);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initAdapter() {
        if (talkList == null) {
            talkList = new ArrayList<>();
        }
        chatAdapter = new ChatAdapter(this, talkList);
        recycler_view.setAdapter(chatAdapter);
    }

    // 发送按钮
    public void send(View view) {

        if (editName.getText().toString().equals("")) {
            Toast.makeText(this, "昵称不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        talkList.add(new Talk(editName.getText().toString(), editText.getText().toString()));
        editText.setText("");
        chatAdapter.notifyDataSetChanged();
        recycler_view.scrollToPosition(talkList.size() - 1);
    }
}

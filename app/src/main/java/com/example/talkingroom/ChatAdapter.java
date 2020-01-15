package com.example.talkingroom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private List<Talk> talkList;
    private Context context;
    public ChatAdapter(Context context, List<Talk> talkList) {
        this.talkList = talkList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textName.setText(talkList.get(position).getName());
        holder.textChat.setText(talkList.get(position).getText());
        holder.textChat.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                System.out.println("ggggg");
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", talkList.get(position).getName());
                intent.putExtra("content", talkList.get(position).getText());
                context.startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return talkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textChat;
        TextView textName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textChat = itemView.findViewById(R.id.textChat);
            textName = itemView.findViewById(R.id.textName);
        }
    }
}

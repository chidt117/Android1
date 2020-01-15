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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<Talk> talkList;
    private Context context;
    public MainAdapter(Context context, List<Talk> talkList) {
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

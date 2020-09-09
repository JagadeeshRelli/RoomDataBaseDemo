package com.example.roomdatabasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.StudentViewHolder> {

    Context stdctx;
    List<StudentEntity> list;


    public MyAdapter(Context stdctx, List<StudentEntity> list) {
        this.stdctx = stdctx;
        this.list = list;
    }

    @NonNull
    @Override


    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(stdctx).
                inflate(R.layout.every_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

        holder.username.setText(list.get(position).getName());
        holder.rollnum.setText(list.get(position).getRollnum());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView edit, delete, username, rollnum;

        public StudentViewHolder(View item) {


            super(item);

            edit = item.findViewById(R.id.edit);
            delete = item.findViewById(R.id.delete);
            rollnum = item.findViewById(R.id.rollnum);
            username = item.findViewById(R.id.username);


        }
    }
}

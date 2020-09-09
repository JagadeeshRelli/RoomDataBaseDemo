package com.example.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    Button save, retrieve;
    EditText username, rollnum;
    MyAdapter adapter;
    StudentDataBase database;
    StudentEntity entity;
    List<StudentEntity> entityList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.save);
        retrieve = findViewById(R.id.retrieve);
        username = findViewById(R.id.username);
        rollnum = findViewById(R.id.rollnum);
        recyclerview=findViewById(R.id.recyclerview);

        database = Room.databaseBuilder(this, StudentDataBase.class, "name").allowMainThreadQueries().build();


    }


    public void saveData(View view) {
        String uname = username.getText().toString();
        String rollno = rollnum.getText().toString();
        entity=new StudentEntity();
        entity.setName(uname);
        entity.setRollnum(rollno);
        database.studentdao().insert(entity);
        Toast.makeText(this, "inserted"+uname, Toast.LENGTH_SHORT).show();


    }

    public void retrieveData(View view) {
        entityList=database.studentdao().retrieve();
        adapter=new MyAdapter(this,entityList);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }
}

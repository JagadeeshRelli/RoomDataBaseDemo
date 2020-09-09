package com.example.roomdatabasedemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
@Insert
void insert(StudentEntity entity);
@Update
void update(StudentEntity entity);
@Delete
void delete(StudentEntity entity);
@Query("SELECT * FROM userdetails")
List<StudentEntity> retrieve();




}

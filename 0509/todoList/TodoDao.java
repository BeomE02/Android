package com.example.todomanager.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todomanager.model.TodoItem;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insertTodo(TodoItem todo);

    @Update
    void updateTodo(TodoItem todo);

    @Delete
    void deleteTodo(TodoItem todo); // ✅ 개별 삭제

    @Query("DELETE FROM TodoItem WHERE timestamp >= :todayStart")
    void deleteAllTodayTodos(long todayStart); // ✅ 오늘 항목 전체 삭제

    @Query("SELECT * FROM TodoItem WHERE timestamp >= :todayStart ORDER BY timestamp DESC")
    List<TodoItem> getTodayTodos(long todayStart);
}

package com.example.activityfragmentcomm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE_OPEN_TODO = 1234; // Random.com
    private CustomAdapter adapter;
    private ListView lvDisplayTodo;
    private FloatingActionButton createTodo;
    private List<TodoTask> dataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
//        adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1);
//        adapter = new CustomAdapter(this,
//                android.R.layout.simple_list_item_2);
        lvDisplayTodo = findViewById(R.id.lv_display_todo);
//        lvDisplayTodo.setAdapter(adapter);
        createTodo = findViewById(R.id.fab_add_todo);

        createTodo.setOnClickListener(this::openCreateActivity);
    }

    private void openCreateActivity(View view) {
        Intent createTodoActivity = new Intent();
        createTodoActivity.setClass(this, CreateActivity.class);
        //startActivity(createTodoActivity);
        startActivityForResult(createTodoActivity ,
                REQ_CODE_OPEN_TODO);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQ_CODE_OPEN_TODO){
            if (resultCode == RESULT_OK){
                if (data != null){
                    String newTodo = data.getStringExtra(CreateActivity.KEY_NEW_TODO);
                    String newCategory = data.getStringExtra(CreateActivity.KEY_NEW_CAT);
                    updateAdapter(newTodo, newCategory);
                }
            }
        }
    }

    private void updateAdapter(String newTodo, String newCategory) {
        TodoTask todoTask = new TodoTask();
        todoTask.setTodoCategory(newCategory);
        todoTask.setTodoName(newTodo);

        dataSet.add(todoTask);
        adapter = new CustomAdapter(this, dataSet);
        lvDisplayTodo.setAdapter(adapter);

        //adapter.add(todoTask);
    }
}
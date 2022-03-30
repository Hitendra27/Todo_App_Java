package com.example.activityfragmentcomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.EmptyStackException;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener, CreateCategoryFragment.OnCreateCategory {

    public static final String KEY_NEW_TODO = "CreateActivity_KEY_NEW_TODO" ;
    private Button createTodo;
    private EditText etNewTodo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity);

        initViews();

    }

    private void initViews() {
        createTodo = findViewById(R.id.btn_create_todo);
        etNewTodo = findViewById(R.id.et_new_todo);
        createTodo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (etNewTodo.getText().toString().isEmpty())
            showToast();
        else{
            Intent passData = new Intent();
            passData.putExtra(KEY_NEW_TODO, etNewTodo.getText().toString());
            setResult(RESULT_OK, passData);
            finish(); // terminate current Activity!!
        }

    }

    private void showToast() {
        Toast.makeText(this, "Cannot have empty string", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addNewCategory(String newCategory) {
        Toast.makeText(this, newCategory, Toast.LENGTH_SHORT).show();
    }
}

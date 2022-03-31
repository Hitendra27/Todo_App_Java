package com.example.activityfragmentcomm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<TodoTask>{

    private List<TodoTask> dataSet;

    public CustomAdapter(@NonNull Context context, List<TodoTask> dataSet) {
        super(context, 0, dataSet);

    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        View currentview = convertView;

        if (currentview == null) {
            currentview = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_2,
                            parent,false);
            TodoTask currentElement = getItem(position);

            onBind(currentElement, currentview);

           // return currentview;
    }
        return currentview;
    }

    private void onBind(TodoTask currentElement, View currentview) {
        ((TextView)currentview.findViewById(android.R.id.text1)).setText(
                currentElement.getTodoName()
        );

        ((TextView)currentview.findViewById(android.R.id.text2)).setText(
                currentElement.getTodoName()
        );



    }
    }



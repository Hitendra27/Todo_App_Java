package com.example.activityfragmentcomm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CreateCategoryFragment extends Fragment {

    private EditText createCategory;
    private Button saveCategory;

    public interface OnCreateCategory{
        void addNewCategory(String newCategory);
    }

    private OnCreateCategory listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CreateActivity)
            listener = (CreateActivity) context;
        else
            throw new IllegalArgumentException("Incorrect Host Activity");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View createLayout =
                inflater.inflate(R.layout.create_category_fragment,
                container,
                false);

        initViews(createLayout);

        return createLayout;
    }

    private void initViews(View createLayout) {
        createCategory = createLayout.findViewById(R.id.et_create_category);
        saveCategory = createLayout.findViewById(R.id.btn_save_category);

        saveCategory.setOnClickListener(
                (__)->{
                    String newCategory = createCategory.getText().toString();

                    listener.addNewCategory(newCategory);
                }
        );



    }
}

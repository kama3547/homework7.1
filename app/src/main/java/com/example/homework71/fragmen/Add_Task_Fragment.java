package com.example.homework71.fragmen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.homework71.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Add_Task_Fragment extends Fragment {

    private EditText etTitle,etDescription;
    private Button btnAddTask;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String mParam1;
    private String mParam2;
    private int mParam3;

    public Add_Task_Fragment() {
    }


    public static Add_Task_Fragment newInstance(String param1, String param2,int position) {
        Add_Task_Fragment fragment = new Add_Task_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add__task_, container, false);
        etTitle = view.findViewById(R.id.et_title);
        etDescription = view.findViewById(R.id.et_description);
        btnAddTask = view.findViewById(R.id.btn_add_task);
        if (requireArguments() != null)
            etTitle.setText(mParam1);
        etDescription.setText(mParam2);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", etTitle.getText().toString());
                bundle.putString("description", etDescription.getText().toString());
                bundle.putInt("position", mParam3);
                getActivity().getSupportFragmentManager().setFragmentResult("editTask ", bundle);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title",etTitle.getText().toString());
                bundle.putString("description",etDescription.getText().toString());
                getActivity().getSupportFragmentManager().setFragmentResult("newTask",bundle);
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
        return view ;
    }
}
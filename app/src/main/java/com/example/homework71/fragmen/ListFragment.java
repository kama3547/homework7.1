package com.example.homework71.fragmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework71.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TaskAdapter adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ListFragment() {
    }


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        adapter = new TaskAdapter(requireContext());
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        fab = view.findViewById(R.id.btn_open_add_task);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("AddTaskFragment").replace(R.id.container_fragment, Add_Task_Fragment.newInstance(model.getTitle(), model.description().position)).commit();
            }
        });
        getActivity().getSupportFragmentManager().setFragmentResultListener("newTask", requireActivity(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                TaskModel model = new TaskModel(result.getString("title"), result.getString("description"));
                adapter.addTask(model);

                getActivity().getSupportFragmentManager().setFragmentResultListener("editTask", requireActivity(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        TaskModel model = new TaskModel(result.getString("title"), result.getString("description"));
                        adapter.editTask(model, result.getInt("position"));


                        adapter.setListener(new IOnTaskClickListener() {
                            @Override
                            public void onClick(TaskModel model, int position) {
                                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("addTaskFragment").replace(R.id.container_fragment, Add_Task_Fragment.newInstance(model.getTitle(), model.getDescription(), position)).commit();
                            }
                        });
                        recyclerView.setAdapter(adapter);
                        return view;
                    }
                });
            }
        });
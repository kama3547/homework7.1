package com.example.homework71.fragmen;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework71.R;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    List<TaskModel> list = new ArrayList<>();
    LayoutInflater inflater;
    IOnTaskClickListener onTaskClickListener;

    public void setListener (IOnTaskClickListener clickListener){
        this.onTaskClickListener = clickListener;
    }


    public TaskAdapter (Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void  addTask (TaskModel model){
        this.list.add(model);
        notifyDataSetChanged();
    }


    public void  editTask (TaskModel model,int position){
        this.list.set(position, model);
        notifyDataSetChanged(position);
    }

    private void notifyDataSetChanged(int position) {
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_task,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TaskAdapter.TaskViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;

        public TaskViewHolder(@NonNull  View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title_holder);
            description = itemView.findViewById(R.id.txt_description_holder);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTaskClickListener.onClick(list.get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }
    }
    }



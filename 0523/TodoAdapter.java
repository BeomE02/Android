package com.example.todomanager.adapter;

import android.graphics.Paint;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomanager.R;
import com.example.todomanager.model.TodoItem;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private final List<TodoItem> todoList;
    private final OnCompleteClickListener completeClickListener;
    private final OnDeleteClickListener deleteClickListener;

    public interface OnCompleteClickListener {
        void onCompleteClick(TodoItem item);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(TodoItem item);
    }

    public TodoAdapter(List<TodoItem> todoList,
                       OnCompleteClickListener completeClickListener,
                       OnDeleteClickListener deleteClickListener) {
        this.todoList = todoList;
        this.completeClickListener = completeClickListener;
        this.deleteClickListener = deleteClickListener;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TodoItem item = todoList.get(position);

        holder.tvTitle.setText(item.title);
        holder.tvContent.setText(item.content);
        holder.tvContent.setVisibility(item.content.trim().isEmpty() ? View.GONE : View.VISIBLE);

        if (item.isDone) {
            holder.tvTitle.setPaintFlags(holder.tvTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.btnComplete.setVisibility(View.GONE);
            holder.btnDelete.setVisibility(View.GONE);
            holder.tvCongrats.setVisibility(View.VISIBLE);
        } else {
            holder.tvTitle.setPaintFlags(holder.tvTitle.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.btnComplete.setVisibility(View.VISIBLE);
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.tvCongrats.setVisibility(View.GONE);

            holder.btnComplete.setOnClickListener(v -> {
                if (completeClickListener != null) completeClickListener.onCompleteClick(item);
            });

            holder.btnDelete.setOnClickListener(v -> {
                if (deleteClickListener != null) deleteClickListener.onDeleteClick(item);
            });
        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent, tvCongrats;
        Button btnComplete, btnDelete;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvCongrats = itemView.findViewById(R.id.tvCongrats);
            btnComplete = itemView.findViewById(R.id.btnComplete);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

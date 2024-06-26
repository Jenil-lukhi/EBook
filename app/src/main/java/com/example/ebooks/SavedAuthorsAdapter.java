package com.example.ebooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavedAuthorsAdapter extends RecyclerView.Adapter<SavedAuthorsAdapter.ViewHolder> {

    private List<String> savedAuthors;

    public SavedAuthorsAdapter(List<String> savedAuthors) {
        this.savedAuthors = savedAuthors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_author, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String author = savedAuthors.get(position);
        holder.textView.setText(author);
    }

    @Override
    public int getItemCount() {
        return savedAuthors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.author_name);
        }
    }
}

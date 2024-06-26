package com.example.ebooks;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Save_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    SavedAuthorsAdapter adapter;
    List<String> savedAuthors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        savedAuthors = loadSavedAuthors();
        adapter = new SavedAuthorsAdapter(savedAuthors);
        recyclerView.setAdapter(adapter);
    }

    private List<String> loadSavedAuthors() {
        SharedPreferences sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);
        List<String> authors = new ArrayList<>();
        if (sharedPreferences.getBoolean("isLiked1", false)) {
            authors.add("James Joyce");
        }
        if (sharedPreferences.getBoolean("isLiked2", false)) {
            authors.add("William Shakespeare");
        }
        if (sharedPreferences.getBoolean("isLiked3", false)) {
            authors.add("J.K. Rowling");
        }
        if (sharedPreferences.getBoolean("isLiked4", false)) {
            authors.add("Virginia Woolf");
        }
        if (sharedPreferences.getBoolean("isLiked5", false)) {
            authors.add("Suresh Dalal");
        }
        if (sharedPreferences.getBoolean("isLiked6", false)) {
            authors.add("Suman Shah");
        }
        return authors;
    }
}

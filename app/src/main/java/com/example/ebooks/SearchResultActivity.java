package com.example.ebooks;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SearchResultActivity extends AppCompatActivity {

    TextView searchResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        searchResultTextView = findViewById(R.id.search_result_text);

        String query = getIntent().getStringExtra("query");


        searchResultTextView.setText("Search results for: " + query);

    }

}


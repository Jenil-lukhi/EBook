package com.example.ebooks;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Favorites_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> likedBooks;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);


        likedBooks = new ArrayList<>();
        if (sharedPreferences.getBoolean("isLiked1", false)) {
            likedBooks.add(new Book("A Spy Alone", "https://www.google.co.in/books/edition/A_Spy_Alone/JCbKEAAAQBAJ?hl=en&gbpv=1&printsec=frontcover"));
        }
        if (sharedPreferences.getBoolean("isLiked2", false)) {
            likedBooks.add(new Book("Life's Amazing Secrets", "https://www.google.co.in/books/edition/Life_s_Amazing_Secrets/f7mjDwAAQBAJ?hl=en&gbpv=1&dq=Life%27s+Amazing+Secrets&printsec=frontcover"));
        }
        if (sharedPreferences.getBoolean("isLiked3", false)) {
            likedBooks.add(new Book("Alibi", "https://www.google.co.in/books/edition/Alibi/LyndaLaPlante"));
        }
        if (sharedPreferences.getBoolean("isLiked4", false)) {
            likedBooks.add(new Book("Godan", "https://www.google.co.in/books/edition/Godan/Premchand"));
        }


        bookAdapter = new BookAdapter(likedBooks, url -> {
            openUrl(url);
        });
        recyclerView.setAdapter(bookAdapter);
    }

    private void openUrl(String url) {

    }
}

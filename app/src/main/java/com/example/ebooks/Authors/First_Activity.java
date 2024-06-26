package com.example.ebooks.Authors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ebooks.MainActivity;
import com.example.ebooks.R;

public class First_Activity extends AppCompatActivity {

    View arrowRight;
    View mainLayout,rectangl,rectangle04,rectangle05,rectangle06,rectangle07;
    TextView popularAut, ulysses, finnegansW, theDead, eveline, theSisters, aLittleCl;
    boolean isLiked1;
    SharedPreferences sharedPreferences;

    ImageView image1,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked1", false);

        image1 = findViewById(R.id.group_601);
        save = findViewById(R.id.save);

        save.setImageResource(isLiked1 ? R.drawable.vector5 : R.drawable.vector4);

        save.setOnClickListener(v -> toggleLike(1));

        arrowRight = findViewById(R.id.arrow_right);
        mainLayout = findViewById(R.id.rectangle_1);
        popularAut = findViewById(R.id.popular_aut);
        ulysses = findViewById(R.id.ulysses_);
        finnegansW = findViewById(R.id.finnegans_w);
        theDead = findViewById(R.id.the_dead);
        eveline = findViewById(R.id.eveline);
        theSisters = findViewById(R.id.the_sisters);
        aLittleCl = findViewById(R.id.a_little_cl);


        rectangl = findViewById(R.id.rectangl);
        rectangle04 = findViewById(R.id.rectangle04);
        rectangle05 = findViewById(R.id.rectangle05);
        rectangle06 = findViewById(R.id.rectangle06);
        rectangle07 = findViewById(R.id.rectangle07);


        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(First_Activity.this, Second_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainLayout.setBackgroundColor(Color.WHITE);
                ulysses.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/ULYSSES_Modern_Classics_Series/70TmEAAAQBAJ?hl=en&gbpv=1&dq=ulysses&printsec=frontcover");

            }
        });
        rectangl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangl.setBackgroundColor(Color.WHITE);
                finnegansW.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/FINNEGANS_WAKE/q1JODwAAQBAJ?hl=en&gbpv=1&dq=Finnegans+Wake&printsec=frontcover");

            }
        });
        rectangle04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle04.setBackgroundColor(Color.WHITE);
                theDead.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/The_Dead_and_Other_Stories/an6KAwAAQBAJ?hl=en&gbpv=1&dq=james+joyce+books+The+Dead&printsec=frontcover");

            }
        });
        rectangle05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle05.setBackgroundColor(Color.WHITE);
                eveline.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Counterparts/3IHhAwAAQBAJ?hl=en&gbpv=1");

            }
        });
        rectangle06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle06.setBackgroundColor(Color.WHITE);
                theSisters.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/The_Sisters/koHhAwAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle07.setBackgroundColor(Color.WHITE);
                aLittleCl.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/A_Portrait_of_the_Artist_as_a_Young_Man/a99aAAAAMAAJ?hl=en&gbpv=1");

            }
        });

    }
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    private void toggleLike(int imageIndex) {
        boolean isLiked;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (imageIndex == 1) {
            isLiked1 = !isLiked1;
            editor.putBoolean("isLiked1", isLiked1);
            save.setImageResource(isLiked1 ? R.drawable.vector5 : R.drawable.vector4);
            isLiked = isLiked1;
        } else {
            return;
        }
        editor.apply();
        showToast(isLiked);
        showPopup(isLiked ? "Author Liked!" : "Author Unliked!");
    }
    private void showToast(boolean isLiked) {
        Toast.makeText(this, isLiked ? "Author Liked!" : "Author Unliked!", Toast.LENGTH_SHORT).show();
    }

    private void showPopup(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

}


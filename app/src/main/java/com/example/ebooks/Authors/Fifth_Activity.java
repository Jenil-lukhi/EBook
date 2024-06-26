package com.example.ebooks.Authors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ebooks.R;

public class Fifth_Activity extends AppCompatActivity {

    View arrowLeft;
    View arrowRight;
    View mainLayout,rectangl,rectangle04,rectangle05,rectangle06,rectangle07;
    TextView popularAut, ulysses, finnegansW, theDead, eveline, theSisters, aLittleCl;
    boolean isLiked1;
    SharedPreferences sharedPreferences;
    ImageView image1,save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked5", false);

        image1 = findViewById(R.id.group_601);
        save = findViewById(R.id.save);

        save.setImageResource(isLiked1 ? R.drawable.vector5 : R.drawable.vector4);

        save.setOnClickListener(v -> toggleLike(1));

        arrowRight = findViewById(R.id.arrow_right);
        arrowLeft = findViewById(R.id.arrow_left_);

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
        rectangle07 = findViewById(R.id.rectangl07);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fifth_Activity.this, Fourth_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fifth_Activity.this, Sixth_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainLayout.setBackgroundColor(Color.WHITE);
                ulysses.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Very_Good_Lives/mF2GBwAAQBAJ?hl=en&gbpv=1&dq=harry+potter+and+the+philosopher%27s+stone&printsec=frontcover");

            }
        });
        rectangl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangl.setBackgroundColor(Color.WHITE);
                finnegansW.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/The_Running_Grave/aX27EAAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle04.setBackgroundColor(Color.WHITE);
                theDead.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Career_of_Evil/jFzbCQAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle05.setBackgroundColor(Color.WHITE);
                eveline.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/The_Ickabog/gvfuDwAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle06.setBackgroundColor(Color.WHITE);
                theSisters.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/The_Casual_Vacancy/FjMbGietIZ4C?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle07.setBackgroundColor(Color.WHITE);
                aLittleCl.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Glasul_sa%CC%82ngelui/9dKtEAAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

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
            editor.putBoolean("isLiked5", isLiked1);
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
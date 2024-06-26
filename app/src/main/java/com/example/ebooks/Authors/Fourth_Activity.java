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

public class Fourth_Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_fourth);

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked4", false);

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


        rectangl = findViewById(R.id.rectangl);
        rectangle04 = findViewById(R.id.rectangle04);
        rectangle05 = findViewById(R.id.rectangle05);
        rectangle06 = findViewById(R.id.rectangle06);


        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fourth_Activity.this, Third_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fourth_Activity.this, Fifth_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainLayout.setBackgroundColor(Color.WHITE);
                ulysses.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Mrs_Dalloway/Vx0ZEAAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangl.setBackgroundColor(Color.WHITE);
                finnegansW.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/A_ROOM_OF_ONE_S_OWN/O1JODwAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle04.setBackgroundColor(Color.WHITE);
                theDead.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/To_the_Lighthouse/O61n4NcQlUkC?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle05.setBackgroundColor(Color.WHITE);
                eveline.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Orlando/waY3ksumjxUC?hl=en&gbpv=1&printsec=frontcover");

            }
        });
        rectangle06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle06.setBackgroundColor(Color.WHITE);
                theSisters.setTextColor(Color.BLACK);

                openUrl("https://www.google.co.in/books/edition/Moments_Of_Being/eMwpDwAAQBAJ?hl=en&gbpv=1&printsec=frontcover");

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
            editor.putBoolean("isLiked4", isLiked1);
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
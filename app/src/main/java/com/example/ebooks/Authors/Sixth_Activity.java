package com.example.ebooks.Authors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ebooks.R;

public class Sixth_Activity extends AppCompatActivity {

    View arrowLeft;
    boolean isLiked1;
    SharedPreferences sharedPreferences;
    ImageView image1,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked6", false);

        image1 = findViewById(R.id.group_601);
        save = findViewById(R.id.save);

        save.setImageResource(isLiked1 ? R.drawable.vector5 : R.drawable.vector4);

        save.setOnClickListener(v -> toggleLike(1));


        arrowLeft = findViewById(R.id.arrow_left_);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sixth_Activity.this, Fifth_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void toggleLike(int imageIndex) {
        boolean isLiked;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (imageIndex == 1) {
            isLiked1 = !isLiked1;
            editor.putBoolean("isLiked6", isLiked1);
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
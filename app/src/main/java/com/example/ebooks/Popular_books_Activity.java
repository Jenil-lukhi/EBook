package com.example.ebooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Popular_books_Activity extends AppCompatActivity {

    private ImageView image1, image2, image3, image4;
    private ImageView like1, like2, like3, like4;
    private boolean isLiked1, isLiked2, isLiked3, isLiked4;
    private SharedPreferences sharedPreferences;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_books);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd (adRequest);

        sharedPreferences = getSharedPreferences("liked_books", MODE_PRIVATE);

        isLiked1 = sharedPreferences.getBoolean("isLiked1", false);
        isLiked2 = sharedPreferences.getBoolean("isLiked2", false);
        isLiked3 = sharedPreferences.getBoolean("isLiked3", false);
        isLiked4 = sharedPreferences.getBoolean("isLiked4", false);

        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);

        like1 = findViewById(R.id.like1);
        like2 = findViewById(R.id.like2);
        like3 = findViewById(R.id.like3);
        like4 = findViewById(R.id.like4);

        like1.setImageResource(isLiked1 ? R.drawable.like2 : R.drawable.vector3);
        like2.setImageResource(isLiked2 ? R.drawable.like2 : R.drawable.vector3);
        like3.setImageResource(isLiked3 ? R.drawable.like2 : R.drawable.vector3);
        like4.setImageResource(isLiked4 ? R.drawable.like2 : R.drawable.vector3);

        image1.setOnClickListener(v -> openUrl("https://www.google.co.in/books/edition/A_Spy_Alone/JCbKEAAAQBAJ?hl=en&gbpv=1&printsec=frontcover"));
        image2.setOnClickListener(v -> openUrl("https://www.google.co.in/books/edition/Life_s_Amazing_Secrets/f7mjDwAAQBAJ?hl=en&gbpv=1&dq=Life%27s+Amazing+Secrets&printsec=frontcover"));
        image3.setOnClickListener(v -> openUrl("https://www.google.co.in/books/edition/Alibi/LyndaLaPlante"));
        image4.setOnClickListener(v -> openUrl("https://www.google.co.in/books/edition/Godan/Premchand"));

        like1.setOnClickListener(v -> toggleLike(1));
        like2.setOnClickListener(v -> toggleLike(2));
        like3.setOnClickListener(v -> toggleLike(3));
        like4.setOnClickListener(v -> toggleLike(4));
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void toggleLike(int imageIndex) {
        boolean isLiked;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (imageIndex) {
            case 1:
                isLiked1 = !isLiked1;
                editor.putBoolean("isLiked1", isLiked1);
                like1.setImageResource(isLiked1 ? R.drawable.like2 : R.drawable.vector3);
                isLiked = isLiked1;
                break;
            case 2:
                isLiked2 = !isLiked2;
                editor.putBoolean("isLiked2", isLiked2);
                like2.setImageResource(isLiked2 ? R.drawable.like2 : R.drawable.vector3);
                isLiked = isLiked2;
                break;
            case 3:
                isLiked3 = !isLiked3;
                editor.putBoolean("isLiked3", isLiked3);
                like3.setImageResource(isLiked3 ? R.drawable.like2 : R.drawable.vector3);
                isLiked = isLiked3;
                break;
            case 4:
                isLiked4 = !isLiked4;
                editor.putBoolean("isLiked4", isLiked4);
                like4.setImageResource(isLiked4 ? R.drawable.like2 : R.drawable.vector3);
                isLiked = isLiked4;
                break;
            default:
                return;
        }
        editor.apply(); // Save the changes
        showToast(isLiked);
        showPopup(isLiked ? "Book Liked!" : "Book Unliked!");
    }

    private void showToast(boolean isLiked) {
        Toast.makeText(this, isLiked ? "Book Liked!" : "Book Unliked!", Toast.LENGTH_SHORT).show();
    }

    private void showPopup(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}

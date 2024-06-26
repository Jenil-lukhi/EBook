package com.example.ebooks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Ebooks_Fragment extends Fragment {

    ImageView img1,img2,img3,img4,img5,img6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ebooks_, container, false);

        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        img4 = view.findViewById(R.id.img4);
        img5 = view.findViewById(R.id.img5);
        img6 = view.findViewById(R.id.img6);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/American_Prometheus/F79LEAAAQBAJ?hl=en&gbpv=1&dq=American+Prometheus:+The+Triumph+And+Tragedy+Of+J.+Robert+Oppenheimer&printsec=frontcover"));
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/The_Oath_of_the_Vayuputras/ZO9gBQAAQBAJ?hl=en&gbpv=1"));
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/The_Great_Indian_Novel/9eD7DQAAQBAJ?hl=en&gbpv=1"));
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/Steve_Jobs/8U2oAAAAQBAJ?hl=en&gbpv=1&dq=steve+jobs+book&printsec=frontcover"));
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/The_Ministry_of_Time/nxrdEAAAQBAJ?hl=en&gbpv=1"));
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/The_Great_Gatsby/5gPYEAAAQBAJ?hl=en&gbpv=1&dq=The+Great+Gatsby&printsec=frontcover"));
                startActivity(intent);
            }
        });

        return view;
    }
}

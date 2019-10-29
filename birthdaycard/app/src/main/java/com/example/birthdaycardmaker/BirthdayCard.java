package com.example.birthdaycardmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BirthdayCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_card);


        Intent intent = getIntent();
        String from=intent.getStringExtra(MainActivity.FROM);
        String to=intent.getStringExtra(MainActivity.TO);
        String message=intent.getStringExtra(MainActivity.MESSAGE);
        String urii=intent.getStringExtra(MainActivity.URI);
        TextView From= findViewById(R.id.from);
        TextView To= findViewById(R.id.to);
        TextView Message= findViewById(R.id.message);
        From.setText(from);
        To.setText(to);
        Message.setText(message);
        Uri uri = Uri.parse(urii);
        ImageView imageView = (ImageView) findViewById(R.id.imageView23);
        imageView.setImageURI(uri);



    }
}

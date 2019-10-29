package com.example.birthdaycardmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String FROM="from";
    public static final String TO="to";
    public static final String MESSAGE="Message";
    public static final String URI="Uri";
    private int PICK_IMAGE_REQUEST = 1;
    android.net.Uri imageUri;
    ImageView imageView;
    String Uri="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void textsend(View view){
        Intent intent = new Intent(this, BirthdayCard.class);
        EditText editText =(EditText) findViewById(R.id.from);
        EditText editText2 =(EditText) findViewById(R.id.to);
        EditText editText3 =(EditText) findViewById(R.id.message);
        String from=editText.getText().toString();
        String to=editText2.getText().toString();
        String message=editText3.getText().toString();
        intent.putExtra(FROM,from);
        intent.putExtra(TO,to);
        intent.putExtra(MESSAGE,message);
        intent.putExtra(URI,Uri);
        startActivity(intent);
    }

    public void chooseImage(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE_REQUEST);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST){
            imageUri = data.getData();
            String suri=imageUri.toString();
            Uri=suri;
            imageView.setImageURI(imageUri);
        }
    }


}

package com.example.homework2;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class helt extends AppCompatActivity {

    Button browsBtn, cameraBtn, galleryBtn;
    ImageView imageView;
       public  static final int code=20;
    Uri uri;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helt);
        browsBtn = findViewById(R.id.browser);
        cameraBtn = findViewById(R.id.camera);
        galleryBtn = findViewById(R.id.gallery);
        imageView = findViewById(R.id.imageView);
       browsBtn.setOnClickListener(v -> {
           Intent browse = new Intent(Intent.ACTION_WEB_SEARCH);
           startActivity(browse);
       });
       cameraBtn.setOnClickListener(v -> {
      Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       intent.putExtra("android.intent.extras.CAMERA_FACING",1);
      startActivity(intent);

       });
       galleryBtn.setOnClickListener(v -> {
           Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
             intent.addCategory(Intent.CATEGORY_OPENABLE);
           intent.setType("image/*");
           startActivityForResult(intent,20);
            startActivity(intent);

       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==20&&resultCode==RESULT_OK&&data!=null){
        uri=data.getData();
        imageView.setImageURI(uri);
        }



    }
}
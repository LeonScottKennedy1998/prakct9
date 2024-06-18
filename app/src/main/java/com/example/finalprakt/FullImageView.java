package com.example.finalprakt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class FullImageView extends AppCompatActivity {
    ImageView fullImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_image_view);
        fullImage = findViewById(R.id.full_image);
        String imgUriSrc = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imgUriSrc);
        try{
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            fullImage.setImageBitmap(selectedImage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

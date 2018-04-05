package com.example.prajwalkulkarni.prog4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);

//Setting the Bitmap as background for the ImageView

        ImageView i = (ImageView) findViewById(R.id.imageView);

        i.setBackgroundDrawable(new BitmapDrawable(bg));

//Creating the Canvas Object

        Canvas canvas = new Canvas(bg);

//Creating the Paint Object and set its color & TextSiz
        Paint paint = new Paint();

        paint.setColor(Color.BLUE); paint.setTextSize(50);

//To draw a Rectangle

        canvas.drawText("Rectangle", 420, 150, paint);

        canvas.drawRect(400, 200, 650, 700, paint);
    }
}

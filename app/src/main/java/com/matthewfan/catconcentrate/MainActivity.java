package com.matthewfan.catconcentrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.background, opt);

//        Log.d("Resource Dim", String.valueOf(opt.outHeight));
//        Log.d("Wind Dim" , String.valueOf(Resources.getSystem().getDisplayMetrics().heightPixels));

        ImageView backgroundImage = findViewById(R.id.repeatingBackgroundImageView);

        final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
        final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
        final int BACKGROUND_HEIGHT = opt.outHeight;
        final int BACKGROUND_WIDTH = opt.outWidth;

        Log.d("Screen dim", "Width: " + String.valueOf(SCREEN_WIDTH));
        Log.d("Screen dim", "Height: " + String.valueOf(SCREEN_HEIGHT));

        final RectF SCREEN_RECT = new RectF(0 , 0 , SCREEN_WIDTH , SCREEN_HEIGHT);
        final RectF BACKGROUND_RECT = new RectF(0 , 0 , BACKGROUND_WIDTH , BACKGROUND_HEIGHT);

        Matrix backgroundMatrix = new Matrix();
        backgroundMatrix.setRectToRect(BACKGROUND_RECT , SCREEN_RECT , Matrix.ScaleToFit.FILL);
//        backgroundMatrix.postRotate(10);




//        backgroundMatrix.set(backgroundImage.getImageMatrix());
//        backgroundMatrix.postRotate(10);
//        backgroundMatrix.postScale(2f , .5f);

//        backgroundImage.setScaleType(ImageView.ScaleType.MATRIX);
        backgroundImage.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.d("Matrix" , backgroundImage.getMatrix().toString());


        backgroundImage.setImageMatrix(backgroundMatrix);
        Log.d("Matrix" , backgroundMatrix.toString());


    }
}

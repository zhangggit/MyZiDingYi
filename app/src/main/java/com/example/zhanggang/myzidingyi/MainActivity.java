package com.example.zhanggang.myzidingyi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image1 = (ImageView) findViewById(R.id.image1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);  //获得图片
        image1.setImageDrawable(new MyView(bitmap)); //设置图片


        ImageView image2 = (ImageView) findViewById(R.id.image2);
        image2.setImageDrawable(new MyView2(bitmap));

    }
}

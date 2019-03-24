package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        Intent intent = getIntent();
        Albums albums = intent.getParcelableExtra("albums");

        textView1.setText(String.valueOf(albums.getUserId()));
        textView2.setText(String.valueOf(albums.getId()));
        textView3.setText(albums.getTitle());
    }
}

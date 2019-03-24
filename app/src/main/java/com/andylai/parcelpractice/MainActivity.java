package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button mPassObjectByParcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPassObjectByParcel = findViewById(R.id.button1);

        mPassObjectByParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Albums cloud = new Albums(2, 3, "Cloud");
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                intent.putExtra("cloud", cloud);
                startActivity(intent);
            }
        });


    }
}
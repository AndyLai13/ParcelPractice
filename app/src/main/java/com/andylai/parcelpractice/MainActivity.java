package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andylai.parcelpractice.ParcelObject.ExtendParcel;
import com.andylai.parcelpractice.ParcelObject.SimpleParcel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleParcel simpleParcel = new SimpleParcel(10, "SPString");
        ExtendParcel extendParcel = new ExtendParcel(20, 40, "EPString");
        final ParcelObject object = new ParcelObject(100, "POString", simpleParcel, extendParcel);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("parcelobj", object);
                startActivity(intent);
            }
        });
    }
}
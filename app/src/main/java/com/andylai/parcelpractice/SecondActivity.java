package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static com.andylai.parcelpractice.ParcelObject.*;

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
        ParcelObject parcelObject = intent.getParcelableExtra("parcelobj");
        if (parcelObject != null) {
            Log.d("Andy", "pbInt = " + parcelObject.pbInt);
            Log.d("Andy", "pbInt = " + parcelObject.pbString);
            ExtendParcel extendParcel = parcelObject.extendParcel;
            if (extendParcel != null) {
                Log.d("Andy", "apInt = " + extendParcel.apInt);
                Log.d("Andy", "epInt = " + extendParcel.epInt);
                Log.d("Andy", "epString = " + extendParcel.epString);
            }
            SimpleParcel simpleParcel = parcelObject.simpleParcel;
            if (simpleParcel != null) {
                Log.d("Andy", "spInt = " + simpleParcel.spInt);
                Log.d("Andy", "spString = " + simpleParcel.spString);

            }
        }

    }
}

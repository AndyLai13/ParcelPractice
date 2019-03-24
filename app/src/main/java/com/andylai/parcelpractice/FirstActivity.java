package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        final Albums albums = new Albums(1, 1, "Castle");

        textView1.setText(String.valueOf(albums.getUserId()));
        textView2.setText(String.valueOf(albums.getId()));
        textView3.setText(albums.getTitle());
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("albums", albums);
                startActivity(intent);
            }
        });
    }
}
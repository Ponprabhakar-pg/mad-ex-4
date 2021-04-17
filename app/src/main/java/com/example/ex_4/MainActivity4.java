package com.example.ex_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity4 extends AppCompatActivity{
    String usr,pass,email,mobile,city;
    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button b7;
        usr = getIntent().getStringExtra("a");
        pass = getIntent().getStringExtra("b");
        email = getIntent().getStringExtra("c");
        mobile = getIntent().getStringExtra("d");
        city = getIntent().getStringExtra("e");
        t1 = (TextView)findViewById(R.id.username);
        t2 = (TextView)findViewById(R.id.pass);
        t3 = (TextView)findViewById(R.id.email);
        t4 = (TextView)findViewById(R.id.mobile);
        t5 = (TextView)findViewById(R.id.city);
        t1.setText("Username:  "+usr);
        t1.setTextSize(20);
        t2.setText("Password:  "+pass);
        t2.setTextSize(20);
        t3.setText("Mail ID:  "+email);
        t3.setTextSize(20);
        t4.setText("Mobile No:  "+mobile);
        t4.setTextSize(20);
        t5.setText("City:  "+city);
        t5.setTextSize(20);

        b7 = (Button)findViewById(R.id.button7);

        b7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity4.this,MainActivity.class);
                startActivity(n);
            }
        });



    }
}

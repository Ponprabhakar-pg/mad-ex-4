package com.example.ex_4;

import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity{
    EditText usr,pass;
    Button b5,b6;
    SQLiteDatabase db;
    String s1,s2,s3,s4,s5,s6,s7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db=openOrCreateDatabase("userdata", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(username VARCHAR,password VARCHAR,email VARCHAR,mobile VARCHAR,city VARCHAR);");

        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);

        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                usr = (EditText)findViewById(R.id.username);
                pass = (EditText)findViewById(R.id.pass);
                s1 = usr.getText().toString();
                s2 = pass.getText().toString();
                if(s1.equals("")||s2.equals("")){
                    Toast.makeText(getApplicationContext(),"TextField's Cannot be Empty!",Toast.LENGTH_SHORT).show();
                }
                else {

                    Cursor c = db.rawQuery("SELECT * FROM student WHERE username='"+s1+"'", null);
                    if (c.moveToFirst()) {
                        System.out.println(c.getString(1));
                        s3=c.getString(0);
                        s4=c.getString(1);
                        s5=c.getString(2);
                        s6=c.getString(3);
                        s7=c.getString(4);
                        if(s2.equals(s4)){
                            Toast.makeText(getApplicationContext(), "Login Successfull!", Toast.LENGTH_SHORT).show();
                            Intent n=new Intent(MainActivity3.this,MainActivity4.class);
                            n.putExtra("a",s3);
                            n.putExtra("b",s4);
                            n.putExtra("c",s5);
                            n.putExtra("d",s6);
                            n.putExtra("e",s7);
                            startActivity(n);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password Mismatch!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "No User Found!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(n);
            }
        });

    }
}

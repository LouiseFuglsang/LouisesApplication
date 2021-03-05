package com.example.louisesapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
        public void method(){
            Button Button = new Button();
            Button.setOnClicker(new View.MyInterface() {
                @Override
                public void myOnClick(View view) {

                }
            }
            );
        }
    }


package com.example.louisesapplication;

public class Button {
        View view;

        public void setOnClicker(View.MyInterface onClicker) {
            onClicker.myOnClick(view);
        }
}

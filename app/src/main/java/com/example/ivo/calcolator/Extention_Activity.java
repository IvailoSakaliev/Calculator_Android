package com.example.ivo.calcolator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Extention_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extention_);
    }
    public void BackToMainActivity(View v)
    {
        Intent intent = new Intent(Extention_Activity.this,Calcolator.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);

    }

}

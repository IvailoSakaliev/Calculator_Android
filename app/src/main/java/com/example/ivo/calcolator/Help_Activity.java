package com.example.ivo.calcolator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Help_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_);
    }
    public void BackToMAinActivity(View v)
    {
        Intent i = new Intent(Help_Activity.this , Calcolator.class);
        startActivity(i);
    }

}

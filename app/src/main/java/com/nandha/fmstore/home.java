package com.nandha.fmstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nandha.fmstore.ui.main.MainFragment;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home, MainFragment.newInstance())
                .commitNow();
    }
}

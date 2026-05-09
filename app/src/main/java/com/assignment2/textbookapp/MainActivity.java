package com.assignment2.textbookapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.assignment2.textbookapp.ui.AddTextBookActivity;
import com.assignment2.textbookapp.ui.BrowseBooksActivity;
import com.assignment2.textbookapp.ui.SearchActivity;

public class MainActivity extends AppCompatActivity {

    Button addBookBtn, browseBtn, searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBookBtn = findViewById(R.id.addBookBtn);
        browseBtn = findViewById(R.id.browseBtn);
        searchBtn = findViewById(R.id.searchBtn);

        addBookBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AddTextBookActivity.class)));

        browseBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, BrowseBooksActivity.class)));

        searchBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SearchActivity.class)));
    }
}
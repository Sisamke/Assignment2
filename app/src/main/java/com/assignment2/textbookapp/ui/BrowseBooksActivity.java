package com.assignment2.textbookapp.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.assignment2.textbookapp.R;
import com.assignment2.textbookapp.services.TextbookService;

public class BrowseBooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextbookService service = new TextbookService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BookAdapter adapter = new BookAdapter(service.getAllBooks());
        recyclerView.setAdapter(adapter);
    }
}
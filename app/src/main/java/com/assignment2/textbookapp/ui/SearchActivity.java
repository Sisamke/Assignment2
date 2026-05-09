package com.assignment2.textbookapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.assignment2.textbookapp.R;
import com.assignment2.textbookapp.services.TextbookService;

public class SearchActivity extends AppCompatActivity {

    EditText etSearch;
    Button btnSearchNow;
    TextView txtResult;

    TextbookService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.etSearch);
        btnSearchNow = findViewById(R.id.btnSearchNow);
        txtResult = findViewById(R.id.txtResult);

        service = new TextbookService();

        btnSearchNow.setOnClickListener(v -> {
            String title = etSearch.getText().toString();

            boolean found = service.searchByTitle(title);

            if (found) {
                txtResult.setText("Book found");
            } else {
                txtResult.setText("Book not found");
            }
        });
    }
}
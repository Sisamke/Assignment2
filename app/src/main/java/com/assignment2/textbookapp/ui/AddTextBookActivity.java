package com.assignment2.textbookapp.ui;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.assignment2.textbookapp.R;
import com.assignment2.textbookapp.models.*;
import com.assignment2.textbookapp.services.TextbookService;
import com.assignment2.textbookapp.exceptions.DuplicateBookException;

public class AddTextBookActivity extends AppCompatActivity {

    EditText titleInput, sellerInput, copiesInput, priceInput, accountInput;
    Button submitBtn;

    TextbookService service = new TextbookService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text_book);

        titleInput = findViewById(R.id.titleInput);
        sellerInput = findViewById(R.id.sellerInput);
        copiesInput = findViewById(R.id.copiesInput);
        priceInput = findViewById(R.id.priceInput);
        accountInput = findViewById(R.id.accountInput);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> addBook());
    }

    private void addBook() {
        try {
            String title = titleInput.getText().toString();
            String seller = sellerInput.getText().toString();
            int copies = Integer.parseInt(copiesInput.getText().toString());
            double price = Double.parseDouble(priceInput.getText().toString());
            String account = accountInput.getText().toString();

            // Validate payment
            BankPayment payment = new BankPayment(account);
            payment.validatePayment();

            Textbook book = new Textbook(title, seller, copies, price);
            service.addBook(book);

            Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();

        } catch (DuplicateBookException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
package com.assignment2.textbookapp.services;

import com.assignment2.textbookapp.models.Textbook;
import com.assignment2.textbookapp.interfaces.Searchable;
import com.assignment2.textbookapp.exceptions.DuplicateBookException;

import java.util.ArrayList;
import java.util.List;

public class TextbookService implements Searchable {
    private static List<Textbook> books = new ArrayList<>();

    public void addBook(Textbook book) throws DuplicateBookException {
        for (Textbook b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
                throw new DuplicateBookException("Book already exists");
            }
        }
        books.add(book);
    }

    public List<Textbook> getAllBooks() {
        return books;
    }

    @Override
    public boolean searchByTitle(String title) {
        if (title == null) return false;

        for (Textbook b : books) {
            if (b.getTitle() != null && b.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean searchBySeller(String seller) {
        if (seller == null) return false;

        for (Textbook b : books) {
            if (b.getSeller() != null && b.getSeller().equalsIgnoreCase(seller)) {
                return true;
            }
        }
        return false;
    }
}
package com.assignment2.textbookapp.models;

public class Textbook {
    private String title;
    private String seller;
    private int copies;
    private double price;

    public Textbook(String title, String seller, int copies, double price) {
        this.title = title;
        this.seller = seller;
        this.copies = copies;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getSeller() { return seller; }
    public int getCopies() {return copies; }
    public double getPrice() {return price; }
}

package com.assignment2.textbookapp.models;

public abstract class PaymentInfo {
    protected String accountNumber;

    public abstract void validatePayment();
}

package com.assignment2.textbookapp.models;

public class BankPayment extends PaymentInfo{
    public BankPayment (String accountNumber){
        this.accountNumber = accountNumber;
    }
    @Override
    public void validatePayment(){
        if (accountNumber.length() < 10 ){
            throw new IllegalArgumentException("Invalid bank account");
        }
    }
}

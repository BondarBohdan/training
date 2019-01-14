package com.company.payment;

public class Card implements PaymentMethod {
    private final String cardNumber;
    private final String expDate;
    private final String cvv;

    public Card(String cardNumber, String expDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double sum) {
        System.out.println("Payed " + sum + " by card.");
    }
}

package com.company.payment;

public class Cash implements PaymentMethod {
    @Override
    public void pay(double sum) {
        System.out.println("Payed " + sum + " by cash.");
    }
}

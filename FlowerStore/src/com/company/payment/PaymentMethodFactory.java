package com.company.payment;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(int type){
        return createCash();
    }

    public static PaymentMethod getPaymentMethod(int type, String[] data){
        return createCard(data);
    }

    public static Card createCard(String[] data){
        return new Card(data[0], data[1], data[2]);
    }

    public static Cash createCash(){
        return new Cash();
    }
}

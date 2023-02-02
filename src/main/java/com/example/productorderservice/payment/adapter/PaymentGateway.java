package com.example.productorderservice.payment.adapter;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);

}

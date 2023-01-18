package com.example.productorderservice.payment.application.service;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.payment.application.port.PaymentPort;
import com.example.productorderservice.payment.domain.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
class PaymentService {
    private final PaymentPort paymentPort;

    PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody final PaymentRequest request) {
        final Order order = paymentPort.getOrder(request.orderId());

        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

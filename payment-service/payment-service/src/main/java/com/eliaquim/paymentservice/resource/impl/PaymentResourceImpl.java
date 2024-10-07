package com.eliaquim.paymentservice.resource.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliaquim.paymentservice.model.Payment;
import com.eliaquim.paymentservice.resource.PaymentResource;
import com.eliaquim.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {
	
	private final PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}

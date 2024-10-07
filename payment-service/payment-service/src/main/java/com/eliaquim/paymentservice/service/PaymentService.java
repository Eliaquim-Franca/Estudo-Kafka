package com.eliaquim.paymentservice.service;

import com.eliaquim.paymentservice.model.Payment;

public interface PaymentService {
	void sendPayment(Payment payment);
}

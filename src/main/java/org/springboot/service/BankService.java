package org.springboot.service;

import org.springboot.dao.model.Mandate;

public interface BankService {

    public void sendMandateToBank(Mandate mandate);

    public void initiatePaymentWithBank(Mandate mandate, String orderId);

}

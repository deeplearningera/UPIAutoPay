package org.springboot.service.impl;

import org.springboot.dao.model.Mandate;
import org.springboot.dao.model.MandateHistory;
import org.springboot.dao.repository.MandateHistoryRepository;
import org.springboot.dao.repository.MandateRepository;
import org.springboot.dto.response.BankCallbackResponse;
import org.springboot.service.BankCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankCallbackServiceImpl implements BankCallbackService {

    @Autowired
    private MandateRepository mandateRepository;

    @Autowired
    private MandateHistoryRepository mandateHistoryRepository;

    @Override
    public void processBankCallback(BankCallbackResponse callbackResponse) {
        String orderId = callbackResponse.getOrderId();
        String bankTxnId = callbackResponse.getBankTxnId();
        String paymentStatus = callbackResponse.getPaymentStatus();

        MandateHistory mandateHistory = mandateHistoryRepository.findByOrderId(orderId);

        if (mandateHistory != null) {
            Mandate mandate = mandateRepository.findById(mandateHistory.getMandateId()).orElse(null);

            if (mandate != null) {
                if ("Success".equals(paymentStatus)) {
                    mandate.setStatus("Approved");
                } else {
                    mandate.setStatus("Rejected");
                }
                mandateRepository.save(mandate);

                mandateHistory.setBankTxnId(bankTxnId);
                mandateHistory.setStatus(paymentStatus);
                mandateHistoryRepository.save(mandateHistory);
            }
        }
    }
}


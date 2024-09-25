package org.springboot.service.impl;

import org.springboot.dao.model.Mandate;
import org.springboot.dao.model.MandateHistory;
import org.springboot.dao.repository.MandateHistoryRepository;
import org.springboot.dao.repository.MandateRepository;
import org.springboot.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private MandateRepository mandateRepository;

    @Autowired
    private MandateHistoryRepository mandateHistoryRepository;

    @Autowired
    private BankService bankService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void executeRecurringPayments() {
        List<Mandate> dueMandates = mandateRepository.findMandatesDueForPayment(LocalDate.now());

        for (Mandate mandate : dueMandates) {
            String orderId = generateOrderId(mandate.getUserId());

            bankService.initiatePaymentWithBank(mandate, orderId);

            MandateHistory history = new MandateHistory();
            mandateHistoryRepository.save(history);
        }
    }

    private String generateOrderId(Long userId) {
        return userId + "_" + LocalDateTime.now().toString();
    }
}


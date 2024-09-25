package org.springboot.service.impl;


import org.springboot.dao.model.BankDetails;
import org.springboot.dao.model.Mandate;
import org.springboot.dao.repository.MandateRepository;
import org.springboot.dto.request.BankPaymentRequest;
import org.springboot.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private MandateRepository mandateRepository;

    @Override
    public void sendMandateToBank(Mandate mandate) {

        BankDetails bankDetails = mandate.getBankDetails();

        boolean isAuthorized = authorizeMandate(mandate, bankDetails);

        if (isAuthorized) {
            mandate.setStatus("Approved");
        } else {
            mandate.setStatus("Rejected");
        }

        mandateRepository.save(mandate);
    }

    private boolean authorizeMandate(Mandate mandate, BankDetails bankDetails) {

        String bankApiUrl = bankDetails.getBankApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        return Boolean.TRUE.equals(restTemplate.postForObject(bankApiUrl, mandate, Boolean.class));
    }

    @Override
    public void initiatePaymentWithBank(Mandate mandate, String orderId) {

        String bankApiUrl = mandate.getBankDetails().getBankApiUrl();

        BankPaymentRequest bankPaymentRequest = BankPaymentRequest.builder()
                .userId(mandate.getUserId())
                .amount(mandate.getAmount())
                .orderId(orderId).build();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(bankApiUrl, bankPaymentRequest, String.class);
    }
}

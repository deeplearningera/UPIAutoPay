package org.springboot.controllers;

import org.springboot.dto.response.BankCallbackResponse;
import org.springboot.service.BankCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankCallbackController {

    @Autowired
    private BankCallbackService bankCallbackService;

    @PostMapping("/bank/callback")
    public ResponseEntity<String> handleBankCallback(@RequestBody BankCallbackResponse callbackResponse) {

        bankCallbackService.processBankCallback(callbackResponse);
        return ResponseEntity.ok("Callback processed successfully");
    }
}

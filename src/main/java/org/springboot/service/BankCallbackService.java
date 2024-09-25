package org.springboot.service;

import org.springboot.dto.response.BankCallbackResponse;

public interface BankCallbackService {

    public void processBankCallback(BankCallbackResponse callbackResponse);

}

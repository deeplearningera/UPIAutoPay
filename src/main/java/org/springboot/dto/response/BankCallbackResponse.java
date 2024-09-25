package org.springboot.dto.response;

import lombok.Data;

@Data
public class BankCallbackResponse {

    private String orderId;
    private String bankTxnId;
    private String paymentStatus;

}

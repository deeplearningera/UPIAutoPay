package org.springboot.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankPaymentRequest {

    private Long userId;
    private Double amount;
    private String orderId;
}

package org.springboot.dao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class MandateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mandate_id")
    private Long mandateId;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "bank_txn_id")
    private String bankTxnId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "status")
    private String status;
}


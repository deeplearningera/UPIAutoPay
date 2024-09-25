package org.springboot.dao.repository;

import org.springboot.dao.model.MandateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandateHistoryRepository extends JpaRepository<MandateHistory, Long> {
    MandateHistory findByOrderId(String orderId);
}

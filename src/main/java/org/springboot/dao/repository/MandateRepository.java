package org.springboot.dao.repository;

import org.springboot.dao.model.Mandate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MandateRepository extends JpaRepository<Mandate, Long> {

    @Query(value = "select * from mandate where next_payment_date <= :currentDateTime and status = ACTIVE", nativeQuery = true)
    public List<Mandate> findMandatesDueForPayment(@Param("currentDateTime") LocalDate currentDateTime);

    List<Mandate> findByStatus(String live);
}

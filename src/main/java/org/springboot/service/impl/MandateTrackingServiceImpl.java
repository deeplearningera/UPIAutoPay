package org.springboot.service.impl;

import org.springboot.dao.model.Mandate;
import org.springboot.dao.repository.MandateRepository;
import org.springboot.service.MandateTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MandateTrackingServiceImpl implements MandateTrackingService {

    @Autowired
    private MandateRepository mandateRepository;

    @Override
    public List<Mandate> getLiveMandates() {
        return mandateRepository.findByStatus("LIVE");
    }

    @Override
    public List<Mandate> getPendingMandates() {
        return mandateRepository.findByStatus("PENDING");
    }

    @Override
    public List<Mandate> getCompletedMandates() {
        return mandateRepository.findByStatus("COMPLETED");
    }
}

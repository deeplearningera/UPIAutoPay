package org.springboot.service;

import org.springboot.dao.model.Mandate;

import java.util.List;

public interface MandateTrackingService {

    public List<Mandate> getLiveMandates();

    public List<Mandate> getPendingMandates();

    public List<Mandate> getCompletedMandates();

}

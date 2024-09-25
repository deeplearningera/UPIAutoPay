package org.springboot.service;

import org.springboot.dao.model.Mandate;
import org.springboot.dto.request.MandateRequest;

public interface MandateService {

    public Mandate createMandate(MandateRequest request);

}

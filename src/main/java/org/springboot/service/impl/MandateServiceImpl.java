package org.springboot.service.impl;

import org.springboot.dao.model.Mandate;
import org.springboot.dao.repository.MandateRepository;
import org.springboot.dto.request.MandateRequest;
import org.springboot.service.BankService;
import org.springboot.service.MandateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MandateServiceImpl implements MandateService {

    @Autowired
    private MandateRepository mandateRepository;

    @Autowired
    private BankService bankService;

    @Override
    public Mandate createMandate(MandateRequest request) {

        Mandate mandate = new Mandate();
        BeanUtils.copyProperties(request, mandate);

        mandateRepository.save(mandate);

        bankService.sendMandateToBank(mandate);

        return mandate;
    }
}

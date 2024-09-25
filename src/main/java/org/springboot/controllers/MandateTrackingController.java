package org.springboot.controllers;

import org.springboot.dao.model.Mandate;
import org.springboot.service.MandateTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mandate")
public class MandateTrackingController {

    @Autowired
    private MandateTrackingService mandateTrackingService;

    @GetMapping("/live")
    public ResponseEntity<List<Mandate>> getLiveMandates() {
        List<Mandate> liveMandates = mandateTrackingService.getLiveMandates();
        return ResponseEntity.ok(liveMandates);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Mandate>> getPendingMandates() {
        List<Mandate> pendingMandates = mandateTrackingService.getPendingMandates();
        return ResponseEntity.ok(pendingMandates);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Mandate>> getCompletedMandates() {
        List<Mandate> completedMandates = mandateTrackingService.getCompletedMandates();
        return ResponseEntity.ok(completedMandates);
    }
}


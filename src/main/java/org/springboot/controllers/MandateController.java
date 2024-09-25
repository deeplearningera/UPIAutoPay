package org.springboot.controllers;


import org.springboot.dao.model.Mandate;
import org.springboot.dto.request.MandateRequest;
import org.springboot.service.MandateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mandate")
public class MandateController {

    @Autowired
    private MandateService mandateService;

    @PostMapping("/create")
    public ResponseEntity<String> createMandate(@Valid @RequestBody MandateRequest request, BindingResult result) {
        if (result.hasErrors()) {
            String errors = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body("Validation failed: " + errors);
        }

        Mandate mandate = mandateService.createMandate(request);
        return ResponseEntity.ok("Mandate created with ID: " + mandate.getMandateId());
    }

}

package com.technical.exam.controller;

import com.technical.exam.models.AutoPartDto;
import com.technical.exam.models.Response;
import com.technical.exam.service.AutoPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class AutoPartController {

    @Autowired
    private AutoPartService service;

    @GetMapping("/validate")
    public ResponseEntity<Response> validate(
            @RequestParam(value = "policy") String policy,
            @RequestParam(value = "numEngine", required = false) String numEngine,
            @RequestParam(value = "numChassis", required = false) String numChassis,
            @RequestParam(value = "numPatent", required = false) String numPatent
    ) {
        return new ResponseEntity<Response>(service.validateData(policy, numEngine, numChassis, numPatent), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AutoPartDto dto) {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

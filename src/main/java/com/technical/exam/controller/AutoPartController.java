package com.technical.exam.controller;

import com.technical.exam.models.AutoPartDto;
import com.technical.exam.models.Request;
import com.technical.exam.models.Response;
import com.technical.exam.models.entity.AutoPart;
import com.technical.exam.service.AutoPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class AutoPartController {

    @Autowired
    private AutoPartService service;

    @GetMapping("/detail")
    public ResponseEntity<Response> detail(
            @RequestParam(value = "policy") String policy,
            @RequestParam(value = "numEngine", required = false) String numEngine,
            @RequestParam(value = "numChassis", required = false) String numChassis,
            @RequestParam(value = "numPatent", required = false) String numPatent
    ) {
        Request request = new Request(policy, numEngine, numChassis, numPatent);
        return new ResponseEntity<Response>(service.getDetail(request), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AutoPart request) {
        service.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

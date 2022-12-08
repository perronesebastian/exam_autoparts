package com.technical.exam.models;

import lombok.Data;

@Data
public class Request {

    private String policy;

    private String numEngine;

    private String numChassis;

    private String numPatent;

    public Request() {}

    public Request(String policy, String numEngine, String numChassis, String numPatent) {
        this.policy = policy;
        this.numChassis = numChassis;
        this.numEngine = numEngine;
        this.numPatent = numPatent;
    }
}

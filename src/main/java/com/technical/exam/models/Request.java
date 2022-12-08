package com.technical.exam.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Request {

    private String policy;

    List<String> autoParts;
    public Request() {}

    public Request(String policy, String numEngine, String numChassis, String numPatent) {
        this.policy = policy;
        this.autoParts = new ArrayList<>();
        autoParts.add(numEngine);
        autoParts.add(numChassis);
        autoParts.add(numPatent);
    }
}

package com.technical.exam.models;

import lombok.Data;

import java.util.List;

@Data
public class Response {

    private String numPolicy;

    private String state;

    private List<AutoPartDto> records;
}

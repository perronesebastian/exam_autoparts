package com.technical.exam.service;

import com.technical.exam.models.AutoPartDto;
import com.technical.exam.models.Response;

public interface AutoPartService {

    void create(AutoPartDto dto);

    Response validateData(String policy, String numEngine, String numChassis, String numPatent);
}

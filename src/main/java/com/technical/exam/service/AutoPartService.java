package com.technical.exam.service;

import com.technical.exam.models.AutoPartDto;
import com.technical.exam.models.Request;
import com.technical.exam.models.Response;
import com.technical.exam.models.entity.AutoPart;

public interface AutoPartService {

    void create(AutoPart request);

    Response getDetail(Request request);
}

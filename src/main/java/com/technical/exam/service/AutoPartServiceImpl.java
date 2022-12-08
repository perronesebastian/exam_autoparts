package com.technical.exam.service;

import com.technical.exam.models.AutoPartDto;
import com.technical.exam.models.Request;
import com.technical.exam.models.Response;
import com.technical.exam.models.entity.AutoPart;
import com.technical.exam.repository.AutoPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoPartServiceImpl implements AutoPartService {

    @Autowired
    private AutoPartRepository repository;

    @Override
    public void create(AutoPart request) {
        AutoPart autoPart = new AutoPart();
        autoPart.setNumAutoPart(request.getNumAutoPart());
        autoPart.setDescriptionAutoPart(request.getDescriptionAutoPart());
        autoPart.setCodComplaint(request.getCodComplaint());
        autoPart.setValid(request.getValid());
        repository.save(autoPart);
    }

    @Override
    public Response getDetail(Request request) {
        List<AutoPart> autoPartList = getAutoPartList(request);
        Response response = new Response();
        response.setNumPolicy(request.getPolicy());
        if (autoPartList.isEmpty()) {
            response.setState("NO_COMPLAINTS");
            return response;
        }
        response.setState("WITH_COMPLAINTS");
        response.setRecords(mapperToDto(autoPartList));
        return response;
    }

    private List<AutoPart> getAutoPartList(Request request) {
        List<AutoPart> autoPartList = repository.findByNumAutoParts(request.getAutoParts());
        return autoPartList;
    }

    private List<AutoPartDto> mapperToDto(List<AutoPart> request) {
        return request.stream().map(element -> {
            AutoPartDto dto = new AutoPartDto();
            dto.setNumAutoPart(element.getNumAutoPart());
            dto.setDescriptionAutoPart(element.getDescriptionAutoPart());
            dto.setCodComplaint(element.getCodComplaint());
            return dto;
        }).collect(Collectors.toList());
    }


}

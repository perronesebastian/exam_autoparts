package com.technical.exam.service;

import com.technical.exam.models.AutoPartDto;
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
    public void create(AutoPartDto dto) {
        AutoPart autoPart = new AutoPart();
        autoPart.setNumAutoPart(dto.getNumAutoPart());
        autoPart.setDescriptionAutoPart(dto.getDescriptionAutoPart());
        autoPart.setCodComplaint(dto.getCodComplaint());
        autoPart.setCurrent(true);
        repository.save(autoPart);
    }

    @Override
    public Response validateData(String policy, String numEngine, String numChassis, String numPatent) {
        List<AutoPart> autoPartList = getAutoParts(numEngine, numChassis, numPatent);
        Response response = new Response();
        response.setNumPolicy(policy);
        if (autoPartList.isEmpty()) {
            response.setState("NO_COMPLAINTS");
            return response;
        }
        response.setState("WITH_COMPLAINTS");
        response.setRecords(mapperToDto(autoPartList));
        return response;
    }

    private List<AutoPart> getAutoParts(String numEngine, String numChassis, String numPatent) {
        return repository.findAll().stream().filter(autoPart ->
                autoPart.getNumAutoPart().equals(numEngine) ||
                        autoPart.getNumAutoPart().equals(numChassis) ||
                        autoPart.getNumAutoPart().equals(numPatent))
                .collect(Collectors.toList());
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

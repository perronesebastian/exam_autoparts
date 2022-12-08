package com.technical.exam.service;

import com.technical.exam.models.Request;
import com.technical.exam.models.entity.AutoPart;
import com.technical.exam.repository.AutoPartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AutoPartServiceImplTest {

    @Mock
    private AutoPartRepository repository;

    @InjectMocks
    private AutoPartServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDetail() {
        Request request = new Request();
        request.setPolicy("11KKX");
        when(repository.findByNumAutoParts(request.getAutoParts())).thenReturn(initList());
        assertEquals(service.getDetail(request).getRecords().size(), 1);
        assertEquals(service.getDetail(request).getRecords().get(0).getNumAutoPart(), "c111111");
    }

    private List<AutoPart> initList() {
        AutoPart autoPart = new AutoPart();
        autoPart.setId(111L);
        autoPart.setNumAutoPart("c111111");
        autoPart.setDescriptionAutoPart("chasis robado");
        autoPart.setCodComplaint("cod_ss1");
        autoPart.setValid((byte) 1);

        List<AutoPart> autoPartList = new ArrayList<>();
        autoPartList.add(autoPart);

        return autoPartList;
    }
}
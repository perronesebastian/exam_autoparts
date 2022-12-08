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
import java.util.Optional;

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
        AutoPart autoPart = new AutoPart();
        when(repository.findByNumAutoPart("c111111")).thenReturn(Optional.of(initAutoPart(autoPart)));
        Request request = new Request();
        request.setNumEngine("c111111");
        assertEquals(service.getDetail(request).getRecords().size(), 1);
        assertEquals(service.getDetail(request).getRecords().get(0).getCodComplaint(), "cod_ss1");
        assertNull(service.getDetail(new Request()).getRecords());
    }

    private AutoPart initAutoPart(AutoPart autoPart) {
        autoPart.setId(111L);
        autoPart.setNumAutoPart("c111111");
        autoPart.setDescriptionAutoPart("chasis robado");
        autoPart.setCodComplaint("cod_ss1");
        autoPart.setCurrent((byte) 1);
        return autoPart;
    }
}
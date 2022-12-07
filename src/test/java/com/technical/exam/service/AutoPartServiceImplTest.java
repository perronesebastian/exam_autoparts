package com.technical.exam.service;

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
    void create() {
    }

    @Test
    void validateData() {
        when(repository.findAll()).thenReturn(initListAutoPart());
        assertNotNull(service.validateData("policy_1", "", "c111111", "12312").getRecords().size());
        assertEquals(service.validateData("policy_1", "2551", "c111111", "12312").getRecords().size(), 1);
    }

    private List<AutoPart> initListAutoPart() {
        List<AutoPart> list = new ArrayList<>();

        AutoPart autoPart1 = new AutoPart();
        autoPart1.setId(111L);
        autoPart1.setNumAutoPart("c111111");
        autoPart1.setDescriptionAutoPart("chasis robado");
        autoPart1.setCodComplaint("cod_ss1");
        autoPart1.setCurrent(true);

        AutoPart autoPart2 = new AutoPart();
        autoPart2.setId(11122L);
        autoPart2.setNumAutoPart("1122554");
        autoPart2.setDescriptionAutoPart("motor robado");
        autoPart2.setCodComplaint("cod_xsw1");
        autoPart2.setCurrent(true);

        list.add(autoPart1);
        list.add(autoPart2);

        return list;
    }
}
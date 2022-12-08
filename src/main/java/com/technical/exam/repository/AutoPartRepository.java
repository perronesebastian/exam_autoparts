package com.technical.exam.repository;

import com.technical.exam.models.entity.AutoPart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoPartRepository extends CrudRepository<AutoPart, Long> {

    @Query("SELECT a FROM AutoPart a WHERE a.numAutoPart IN :request")
    List<AutoPart> findByNumAutoParts(List<String> request);
}

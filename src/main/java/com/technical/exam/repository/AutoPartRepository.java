package com.technical.exam.repository;

import com.technical.exam.models.entity.AutoPart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoPartRepository extends CrudRepository<AutoPart, Long> {

    List<AutoPart> findAll();

}

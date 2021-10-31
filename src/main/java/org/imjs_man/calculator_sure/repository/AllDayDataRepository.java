package org.imjs_man.calculator_sure.repository;

import org.imjs_man.calculator_sure.entity.AllDayDataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllDayDataRepository extends CrudRepository<AllDayDataEntity, Long> {
    List<AllDayDataEntity> findAll();
}
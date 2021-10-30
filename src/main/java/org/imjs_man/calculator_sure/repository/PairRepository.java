package org.imjs_man.calculator_sure.repository;

import org.imjs_man.calculator_sure.entity.MarsToken;
import org.imjs_man.calculator_sure.entity.PairDepth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PairRepository extends CrudRepository<PairDepth, Long> {
    List<PairDepth> findAll();
}

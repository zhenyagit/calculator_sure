
package org.imjs_man.calculator_sure.repository;

import org.imjs_man.calculator_sure.entity.DydxMarketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DydxMarketRepository extends CrudRepository<DydxMarketEntity, Long> {
    List<DydxMarketEntity> findAll();
}

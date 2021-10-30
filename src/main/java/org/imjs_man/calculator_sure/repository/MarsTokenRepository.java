package org.imjs_man.calculator_sure.repository;

import org.imjs_man.calculator_sure.entity.MarsToken;
import org.springframework.data.repository.CrudRepository;

public interface MarsTokenRepository extends CrudRepository<MarsToken, Long> {
    MarsToken findByTokenToSellOrBuySymbol(String symbol);
}

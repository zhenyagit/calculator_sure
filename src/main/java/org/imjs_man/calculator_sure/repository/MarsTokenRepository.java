package org.imjs_man.calculator_sure.repository;

import org.imjs_man.calculator_sure.entity.MarsToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MarsTokenRepository extends CrudRepository<MarsToken, Long> {
    @Query("SELECT t FROM MarsToken t WHERE t.tokenToSellOrBuySymbol = ?1")
    MarsToken findByTokenToSellOrBuySymbol(String symbol);
}

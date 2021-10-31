package org.imjs_man.calculator_sure.service;


import org.imjs_man.calculator_sure.entity.DydxMarketEntity;
import org.imjs_man.calculator_sure.repository.DydxMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DydxMarketService {

    @Autowired
    DydxMarketRepository dydxMarketRepository;

    public void saveAll(List<DydxMarketEntity> markets) {
        dydxMarketRepository.saveAll(markets);
    }

    public List<DydxMarketEntity> getAll() {
        return dydxMarketRepository.findAll();
    }
}

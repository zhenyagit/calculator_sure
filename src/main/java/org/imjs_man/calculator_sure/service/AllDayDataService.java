package org.imjs_man.calculator_sure.service;

import org.imjs_man.calculator_sure.entity.AllDayDataEntity;
import org.imjs_man.calculator_sure.repository.AllDayDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllDayDataService {
    @Autowired
    AllDayDataRepository allDayDataRepository;

    public void saveAll(List<AllDayDataEntity> markets) {
        allDayDataRepository.saveAll(markets);
    }
    public List<AllDayDataEntity> getAll() {
        return allDayDataRepository.findAll();
    }

}

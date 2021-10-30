package org.imjs_man.calculator_sure.service;

import org.imjs_man.calculator_sure.entity.MarsToken;
import org.imjs_man.calculator_sure.entity.PairDepth;
import org.imjs_man.calculator_sure.repository.MarsTokenRepository;
import org.imjs_man.calculator_sure.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PairService
{
    @Autowired
    PairRepository pairRepository;

    public void save(PairDepth pairDepth)
    {
        pairRepository.save(pairDepth);
    }
    public List<PairDepth> getAll()
    {
        return pairRepository.findAll();
    }

}
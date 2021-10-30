package org.imjs_man.calculator_sure.service;


import org.imjs_man.calculator_sure.entity.MarsToken;
import org.imjs_man.calculator_sure.marsApi.MarsParser;
import org.imjs_man.calculator_sure.repository.MarsTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarsTokenService
{
    @Autowired
    MarsTokenRepository marsTokenRepository;
    public MarsToken getMarsTokenBySymbol(String symbol)
    {
        return marsTokenRepository.findByTokenToSellOrBuySymbol(symbol);
    }

}

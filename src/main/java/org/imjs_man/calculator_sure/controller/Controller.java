package org.imjs_man.calculator_sure.controller;

import org.imjs_man.calculator_sure.calculator.AuthForm;
import org.imjs_man.calculator_sure.dydxApi.DydxService;
import org.imjs_man.calculator_sure.entity.AllDayDataEntity;
import org.imjs_man.calculator_sure.entity.DydxMarketEntity;
import org.imjs_man.calculator_sure.service.AllDayDataService;
import org.imjs_man.calculator_sure.service.DydxMarketService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class Controller {
    @Autowired
    DydxMarketService dydxMarketService;
    @Autowired
    AllDayDataService adds;

    @GetMapping
    public ResponseEntity auth(@RequestBody AuthForm authForm) throws JSONException {
        List<DydxMarketEntity> dydxMarketEntities = dydxMarketService.getAll();
        List<AllDayDataEntity> adde = adds.getAll();
        JSONArray array = new JSONArray();
        for(DydxMarketEntity dydxMarketEntity:dydxMarketEntities )
        {
            for(AllDayDataEntity rgr:adde ){
                array.put(rgr.getAskVolume());
                array.put(rgr.getBidVolume());
            }
        }
        return ResponseEntity.ok(array.toString());
    }
}
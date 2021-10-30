package org.imjs_man.calculator_sure.calculator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.imjs_man.calculator_sure.entity.PairDepth;
import org.imjs_man.calculator_sure.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class Calculator {

    @Autowired
    PairService pairService;

    public AllDayDataAskBid finalPrice() {
        List<PairDepth> depths = pairService.getAll();
        List<CalcData> calcDataAsks = new ArrayList<>();
        List<CalcData> calcDataBids = new ArrayList<>();
        for (PairDepth pairDepth: depths)
        {
            Gson gson = new Gson();
            Type itemsListType = new TypeToken<List<OrdersSizePrice>>() {}.getType();
            List<OrdersSizePrice> ordersSizePricesAsks = gson.fromJson(pairDepth.getAsks(), itemsListType);
            List<OrdersSizePrice> ordersSizePricesBids = gson.fromJson(pairDepth.getBids(), itemsListType);
            calcDataAsks.add(avgPrice(ordersSizePricesAsks));
            calcDataBids.add(avgPrice(ordersSizePricesBids));
        }
        CalcData calcDataAsk = finalPrice(calcDataAsks);
        CalcData calcDataBid = finalPrice(calcDataBids);
        AllDayDataAskBid allDayDataAskBid = new AllDayDataAskBid();
        allDayDataAskBid.setAskPrice(calcDataAsk.getAvgPrice());
        allDayDataAskBid.setBidPrice(calcDataBid.getAvgPrice());
        allDayDataAskBid.setAskVolume(calcDataAsk.getFullVolume());
        allDayDataAskBid.setBidVolume(calcDataBid.getFullVolume());
        return allDayDataAskBid;
    }
    public CalcData finalPrice(List<CalcData> calcDatas)
    {
        double summVolume=0;
        double summPriceSize = 0;

        for (CalcData calcData:calcDatas)
        {
            summVolume = summVolume + calcData.getFullVolume();
            summPriceSize = summPriceSize + calcData.getAvgPrice()*calcData.getFullVolume();
        }
        CalcData temp = new CalcData();
        temp.setAvgPrice(1/summVolume*summPriceSize);;
        temp.setFullVolume(summVolume);
        return temp;
    }
    public CalcData avgPrice(List<OrdersSizePrice> ordersSizePrices)
    {

        double summVolume=0;
        double summPriceSize = 0;

        for (OrdersSizePrice ordersSizePrice:ordersSizePrices)
        {
            summVolume = summVolume + ordersSizePrice.getSize();
            summPriceSize = summPriceSize + ordersSizePrice.getSize()*ordersSizePrice.getPrice();
        }
        CalcData temp = new CalcData();
        temp.setAvgPrice(1/summVolume*summPriceSize);;
        temp.setFullVolume(summVolume);
        return temp;

    }
}

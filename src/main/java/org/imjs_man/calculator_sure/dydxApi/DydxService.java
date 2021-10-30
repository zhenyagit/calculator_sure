package org.imjs_man.calculator_sure.dydxApi;

        import org.apache.tomcat.util.json.ParseException;
        import org.imjs_man.calculator_sure.calculator.AllDayDataAskBid;
        import org.imjs_man.calculator_sure.calculator.Calculator;
        import org.imjs_man.calculator_sure.entity.MarsToken;
        import org.imjs_man.calculator_sure.entity.PairDepth;
        import org.imjs_man.calculator_sure.repository.MarsTokenRepository;
        import org.imjs_man.calculator_sure.service.PairService;
        import org.json.JSONException;
        import org.jsoup.Connection;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Service;

        import java.io.Console;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Map;


@Service
@EnableScheduling
public class DydxService {

    @Autowired
    DydxParser dydxParser;

    @Autowired
    PairService pairService;

    @Autowired
    Calculator calculator;

    @Scheduled(fixedDelay = 10000)//todo connector
    public void showCalcData() {
        AllDayDataAskBid allData= calculator.finalPrice();
        System.out.format("Ask price = %f; volume %f\n", allData.getAskPrice(), allData.getAskVolume());
        System.out.format("Bid price = %f; volume %f\n", allData.getBidPrice(), allData.getBidVolume());
        System.out.format("Difference = %f\n", -allData.getBidPrice()+allData.getAskPrice());
    }
    @Scheduled(fixedDelay = 10000)
    public void getAndSaveMarsToken()
    {
        String firstToken = "BTC";
        String secondToken ="USD";
        try {
            Map<String,String> data = dydxParser.getPairDepthFromJson(getDepthByPair(firstToken,secondToken));
            PairDepth pairDepth = new PairDepth();
            pairDepth.setfToken(firstToken);
            pairDepth.setsToken(secondToken);
            pairDepth.setAsks(data.get("asks"));
            pairDepth.setBids(data.get("bids"));
            pairService.save(pairDepth);
        } catch (IOException | ParseException | JSONException e) {
            e.printStackTrace();
        }
    }
    public String getDepthByPair(String tokenName1, String tokenName2) throws IOException {
        try {
            return Jsoup.connect("https://api.dydx.exchange/v3/orderbook/"+tokenName1+"-"+tokenName2)
                    .ignoreContentType(true)
                    .timeout(300000)
                    .get().body().text();
        } catch (IOException e) {
            throw new IOException(e.getMessage()); //todo create exception class
        }
    }
}

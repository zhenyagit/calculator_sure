package org.imjs_man.calculator_sure.dydxApi;

        import org.imjs_man.calculator_sure.entity.MarsToken;
        import org.imjs_man.calculator_sure.repository.MarsTokenRepository;
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


@Service
@EnableScheduling
public class DydxService {

    @Autowired
    DydxParser dydxParser;

    @Autowired
    MarsTokenRepository marsTokenRepository;

    @Scheduled(fixedDelay = 10000)
    public void getAndSaveMarsToken()
    {

        List<MarsToken> marsTokens = new ArrayList<>();
        try {
            marsTokens = marsParser.getMarsTokenFromString(getDataFromUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        marsTokenRepository.saveAll(marsTokens);
    }
    public String getDataFromUrl() throws IOException {
        try {
            String pagination = "{\"page\":0,\"size\":10}";

            String jsonRequest = Jsoup.connect("https://marsbase-backend-master.k8s.sparklingtide.com/api/whalemarket/filter")
                    .data("minRank", "")
                    .data("maxRank", "")
                    .data("minAmount", "")
                    .data("maxAmount", "")
                    .data("timeInMinutes", "")
                    .data("offerMode", "MANUAL")
                    .data("actionType", "BUY")
                    .data("isHot", "false")
                    .data("search", "")
                    .data("pagination", pagination)
                    .data("page", "0")
                    .data("size", "10")
                    .ignoreContentType(true)
                    .timeout(300000)
                    .get().body().text();
            return jsonRequest;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); //todo create exception class
        }
    }
}

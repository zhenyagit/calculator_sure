package org.imjs_man.calculator_sure.marsApi;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.io.IOException;
import java.util.HashSet;

@Component
@EnableScheduling
public class MarsService {

    @Scheduled(fixedDelay = 10000)
    public void getDataFromUrl() {
        try {
            String pagination = "{\"page\":0,\"size\":10}";

            String jsonResponse = Jsoup.connect("https://marsbase-backend-master.k8s.sparklingtide.com/api/whalemarket/filter")
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

            System.out.println(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

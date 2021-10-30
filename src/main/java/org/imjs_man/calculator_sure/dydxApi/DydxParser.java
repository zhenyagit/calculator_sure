package org.imjs_man.calculator_sure.dydxApi;


import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.imjs_man.calculator_sure.entity.PairDepth;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Component
public class DydxParser {
    public Map<String, String> getPairDepthFromJson(String json) throws ParseException, JSONException {
        JSONObject parser = new JSONObject(json);
        String asks = parser.getString("asks");
        String bids = parser.getString("bids");
        Map<String,String> data = new HashMap<>();
        data.put("asks", asks);
        data.put("bids", bids);
        return data;

    }
}

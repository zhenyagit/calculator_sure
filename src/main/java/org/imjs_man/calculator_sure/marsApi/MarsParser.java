package org.imjs_man.calculator_sure.marsApi;


import org.imjs_man.calculator_sure.entity.MarsToken;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class MarsParser {
    public MarsToken getMarsTokenFromString(String json)
    {
        return new Gson().fromJson(json, MarsToken.class);
    }
}

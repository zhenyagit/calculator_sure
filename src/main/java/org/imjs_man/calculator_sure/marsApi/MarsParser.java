package org.imjs_man.calculator_sure.marsApi;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import org.imjs_man.calculator_sure.entity.MarsToken;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class MarsParser {
    public List<MarsToken> getMarsTokenFromString(String json)
    {
        Type listType = new TypeToken<ArrayList<MarsToken>>(){}.getType();

        return new  Gson().fromJson(json, listType);
    }
}

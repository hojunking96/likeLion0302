package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String function;
    private Map<String, String> params;

    public Rq(String command) {
        //limit 인자로 배열의 최대 개수 설정(2라고 설정하면 처음나온 ?에서 양쪽으로 나눠짐)
        String[] commandBits = command.split("\\?", 2);
        function = commandBits[0];

        params = new HashMap<>();
        if (commandBits.length == 1) {
            return;
        }
        String[] paramBits = commandBits[1].split("&");

        for (String paramStr : paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);

            if (paramStrBits.length == 1) {
                continue;
            }

            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }
    }

    public String getFunction() {
        return function;
    }

    public String getParam(String name){
        return params.get(name);
    }
    public long getLongParam(String name, long defaultValue){
        try{
            return Integer.parseInt(getParam(name));
        }catch(NumberFormatException e){

        }
        return defaultValue;
    }


}

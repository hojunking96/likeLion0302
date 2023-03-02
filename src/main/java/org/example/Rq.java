package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String function;
    private Map<String, String> params;

    public Rq(String command) {
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
    public int getIntParam(String name, int defaultValue){
        try{
            return Integer.parseInt(getParam(name));
        }catch(NumberFormatException e){

        }
        return defaultValue;
    }


}

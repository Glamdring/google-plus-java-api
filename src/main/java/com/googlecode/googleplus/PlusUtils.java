package com.googlecode.googleplus;

import java.util.HashMap;
import java.util.Map;

public class PlusUtils {

    public static String addParameters(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        String delimiter = "?";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(delimiter);
            builder.append(entry.getKey() + "=" + entry.getValue());
            delimiter = "&";
        }

        return builder.toString();
    }

    public static Map<String, String> createParamMap(Paging paging) {
        Map<String, String> params = new HashMap<String, String>();
        if (paging != null) {
            paging.fillParameterMap(params);
        }
        return params;
    }
}

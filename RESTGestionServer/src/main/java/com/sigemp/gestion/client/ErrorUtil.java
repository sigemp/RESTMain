/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

/**
 *
 * @author sigem
 */
public class ErrorUtil {

    public static String getErrorObject(String text)  {
        try {
        JSONObject exc = JSONParser.parseStrict(text).isObject();
        if (exc != null && exc.containsKey("errorText")) {
            return exc.get("errorText").isString().stringValue();
        } else if (exc != null && exc.containsKey("exception")) {
            JSONObject nestedExc = exc.get("exception").isObject();
            //return retrieveErrorMessage(nestedExc);
            return "";
        }
    } catch (Exception e) {
        if (text != null) {
            return text;
        } else {
            return "<no reason>";
        }
    }
    return null;
    }
    
}

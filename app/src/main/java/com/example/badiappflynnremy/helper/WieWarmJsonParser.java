package com.example.badiappflynnremy.helper;

import com.example.badiappflynnremy.model.Badi;
import com.example.badiappflynnremy.model.Becken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class WieWarmJsonParser {
    public static Badi createBadiFromJsonString(String badiJsonString) throws JSONException
    {
        Badi badi = new Badi();
        JSONObject jsonObj = new JSONObject(badiJsonString);
        badi.setId(Integer.parseInt(jsonObj.getString("badid")));
        badi.setName(jsonObj.getString("badname"));
        badi.setKanton(jsonObj.getString("kanton"));
        badi.setOrt(jsonObj.getString("ort"));
        badi.setAdresse(jsonObj.getString("adresse1"));
        JSONObject beckenJson = jsonObj.getJSONObject("becken");
        Iterator keys = beckenJson.keys();

        while (keys.hasNext())
        {
            Becken becken = new Becken();
            String key = (String) keys.next();
            JSONObject subObj = beckenJson.getJSONObject(key);
            becken.setName(subObj.getString("beckenname"));
            becken.setTemperature(Double.parseDouble(subObj.getString("temp")));
            becken.setStatus(subObj.getString("status"));
            badi.addBecken(becken);
        }

        return badi;
    }

}

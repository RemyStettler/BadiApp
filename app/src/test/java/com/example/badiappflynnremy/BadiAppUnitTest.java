package com.example.badiappflynnremy;

import com.example.badiappflynnremy.dal.BadiDao;
import com.example.badiappflynnremy.helper.WieWarmJsonParser;
import com.example.badiappflynnremy.model.Badi;

import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BadiAppUnitTest {

    private static final String testJSON = "{\n" + "  \"badid\": \"9000\",\n" +
            "  \"badname\": \"Schwimmbad\",\n" + "  \"kanton\": \"BE\",\n" + "  \"plz\": null,\n" +
            "  \"ort\": \"Bümpliz\",\n" + "  \"adresse1\": \"Bahnhöheweg 70\",\n" +
            "  \"adresse2\": null,\n" + "  \"email\": \"info@bbcag.ch\",\n" + "  \"telefon\": null,\n" +
            "  \"www\": \"www.berufsbildungscenter.ch\",\n" + "  \"long\": null,\n" +
            "  \"lat\": null,\n" + "  \"zeiten\": null,\n" + "  \"preise\": null,\n" +
            "  \"info\": \"Keine speziellen Angaben\",\n" + "  \"wetterort\": \"Bern\",\n" +
            "  \"uv_station_name\": \"Bern\",\n" + "  \"uv_wert\": 1,\n" +
            "  \"uv_date\": \"2017-11-28 00:00:00\",\n" + "  \"uv_date_pretty\": \"28.11.\",\n" +
            "  \"becken\": {\n" + "    \"Schwimmbecken\": {\n" + "      \"beckenid\": 185,\n" +
            "      \"beckenname\": \"Schwimmbecken\",\n" + "      \"temp\": \"22.0\",\n" +
            "      \"date\": \"2017-07-04 08:02:00\",\n" + "      \"typ\": \"Hallenbad\",\n" +
            "      \"status\": \"geöffnet\",\n" + "      \"smskeywords\": \";BEUMPLIZ;\",\n" +
            "      \"smsname\": \"Bbc Schwimmbad\",\n" + "      \"ismain\": \"T   \",\n" +
            "      \"date_pretty\": \"04.07.\"\n" + "    }\n" + "  },\n" + "  \"bilder\": [],\n" +
            "  \"wetter\": [\n" + "    {\n" + "      \"wetter_symbol\": 9,\n" +
            "      \"wetter_temp\": \"3.0\",\n" + "      \"wetter_date\": \"2017-11-29 00:00:00\",\n" +
            "      \"wetter_date_pretty\": \"29.11.\"\n" + "    },\n" + "    {\n" +
            "      \"wetter_symbol\": 15,\n" + "      \"wetter_temp\": \"4.0\",\n" +
            "      \"wetter_date\": \"2017-11-28 00:00:00\",\n" +
            "      \"wetter_date_pretty\": \"28.11.\"\n" + "    }\n" + "  ]\n" + "}";

    private static final String testJSON_noId = "{\n" + " ,\n" +
            "  \"badname\": \"Schwimmbad\",\n" + "  \"kanton\": \"BE\",\n" + "  \"plz\": null,\n" +
            "  \"ort\": \"Bümpliz\",\n" + "  \"adresse1\": \"Bahnhöheweg 70\",\n" +
            "  \"adresse2\": null,\n" + "  \"email\": \"info@bbcag.ch\",\n" + "  \"telefon\": null,\n" +
            "  \"www\": \"www.berufsbildungscenter.ch\",\n" + "  \"long\": null,\n" +
            "  \"lat\": null,\n" + "  \"zeiten\": null,\n" + "  \"preise\": null,\n" +
            "  \"info\": \"Keine speziellen Angaben\",\n" + "  \"wetterort\": \"Bern\",\n" +
            "  \"uv_station_name\": \"Bern\",\n" + "  \"uv_wert\": 1,\n" +
            "  \"uv_date\": \"2017-11-28 00:00:00\",\n" + "  \"uv_date_pretty\": \"28.11.\",\n" +
            "  \"becken\": {\n" + "    \"Schwimmbecken\": {\n" + "      \"beckenid\": 185,\n" +
            "      \"beckenname\": \"Schwimmbecken\",\n" + "      \"temp\": \"22.0\",\n" +
            "      \"date\": \"2017-07-04 08:02:00\",\n" + "      \"typ\": \"Hallenbad\",\n" +
            "      \"status\": \"geöffnet\",\n" + "      \"smskeywords\": \";BEUMPLIZ;\",\n" +
            "      \"smsname\": \"Bbc Schwimmbad\",\n" + "      \"ismain\": \"T   \",\n" +
            "      \"date_pretty\": \"04.07.\"\n" + "    }\n" + "  },\n" + "  \"bilder\": [],\n" +
            "  \"wetter\": [\n" + "    {\n" + "      \"wetter_symbol\": 9,\n" +
            "      \"wetter_temp\": \"3.0\",\n" + "      \"wetter_date\": \"2017-11-29 00:00:00\",\n" +
            "      \"wetter_date_pretty\": \"29.11.\"\n" + "    },\n" + "    {\n" +
            "      \"wetter_symbol\": 15,\n" + "      \"wetter_temp\": \"4.0\",\n" +
            "      \"wetter_date\": \"2017-11-28 00:00:00\",\n" +
            "      \"wetter_date_pretty\": \"28.11.\"\n" + "    }\n" + "  ]\n" + "}";

    @Test
    public void badiDao_BadiGenerationTest() {
        List<Badi> badiList = new ArrayList<Badi>();
        badiList = BadiDao.getAll();
        assertEquals(9, badiList.size());
    }

    @Test
    public void wieWarmJsonParser_createBadiIdTest() {
        Badi testBadi = null;
        try {
            testBadi = WieWarmJsonParser.createBadiFromJsonString(testJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assertEquals(9000, testBadi.getId());
    }

    @Test
    public void wieWarmJsonParser_createBadiWithoutIdTest() {
        Badi testBadi = null;
        try {
            testBadi = WieWarmJsonParser.createBadiFromJsonString(testJSON_noId);
        } catch (JSONException e) {
            assertEquals(null, testBadi);
        }
    }

    @Test
    public void wieWarmJsonParser_createBadiOrtTest() {
        Double expected = 45.0;
        Double actual = 0.0;
        String json = "{" + "\"current\"" + ":" + "{" + "\"temp_c\"" + ":" + "45.0" + "}" + "}";
        try {
            actual = WieWarmJsonParser.createOrtTempFromJsonString(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void wieWarmJsonParser_createBadiOrtTestWithoutTemp() {
        Double expected = 0.0;
        Double actual = 0.0;
        String json = "{" + "\"current\"" + ":" + "{" + "}";
        try {
            actual = WieWarmJsonParser.createOrtTempFromJsonString(json);
        } catch (JSONException e) {
            assertEquals(expected, actual);
        }
    }
}

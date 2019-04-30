package com.example.badiappflynnremy.dal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.badiappflynnremy.BadiDetailsActivity;
import com.example.badiappflynnremy.R;
import com.example.badiappflynnremy.helper.WieWarmJsonParser;
import com.example.badiappflynnremy.model.Badi;
import com.example.badiappflynnremy.model.Becken;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class BadiDao {
    public static List<Badi> getAll() {
        List<Badi> availableBadis = new ArrayList<>();
        availableBadis.add(new Badi(71, "Schwimmbad", "Aarberg", "BE"));
        availableBadis.add(new Badi(27, "Schwimmbad Gruebi", "Adelboden", "BE"));
        availableBadis.add(new Badi(6, "Stadtberner Baeder", "Bern", "BE"));
        availableBadis.add(new Badi(55, "Zürichsee", "", "ZH"));
        availableBadis.add(new Badi(7, "Badebetriebe Thun", "Thun", "BE"));
        availableBadis.add(new Badi(94, "Schwimmbad Biel", "Biel", "BE"));
        availableBadis.add(new Badi(122, "Hallenbad Bolligen", "Bolligen", "BE"));
        availableBadis.add(new Badi(153, "Strandbad Bönigen", "Bönigen", "BE"));
        availableBadis.add(new Badi(219, "Freibad Langnau i.E.", "Langnau i.E.", "BE"));
        availableBadis.add(new Badi(68, "Parkschwimmbad Lyss", "Lyss", "BE"));
        availableBadis.add(new Badi(129, "Parkbad Münsingen", "Münsingen", "BE"));
        availableBadis.add(new Badi(63, "Freibad Ostermundigen", "Ostermundigen", "BE"));
        availableBadis.add(new Badi(145, "Alpamare", "Pfäffikon", "SZ"));

        return availableBadis;
    }
}

package com.example.badiappflynnremy.dal;

import com.example.badiappflynnremy.model.Badi;

import java.util.ArrayList;
import java.util.List;

public class BadiDao {
    public static List<Badi> getAll()
    {
        List<Badi> availableBadis = new ArrayList<>();
        availableBadis.add(new Badi(71, "Schwimmbad", "Aarberg", "BE"));
        availableBadis.add(new Badi(27, "Schwimmbad Gruebi", "Adelboden", "BE"));
        availableBadis.add(new Badi(6, "Stadtberner Baeder", "Bern", "BE"));
        availableBadis.add(new Badi(55, "Zürichsee", "", "ZH"));

        return availableBadis;
    }
}

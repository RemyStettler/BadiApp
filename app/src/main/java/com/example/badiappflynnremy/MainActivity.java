package com.example.badiappflynnremy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.badiappflynnremy.dal.BadiDao;
import com.example.badiappflynnremy.model.Badi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Übersicht");
    }

    private void addBadisToClickableList(){
        ListView badis = findViewById(R.id.badiliste);
        ArrayAdapter<Badi> badiAdapter =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        badiAdapter.addAll(BadiDao.getAll());
        badis.setAdapter(badiAdapter);

    }
}
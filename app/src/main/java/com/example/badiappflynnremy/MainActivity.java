package com.example.badiappflynnremy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.badiappflynnremy.dal.BadiDao;
import com.example.badiappflynnremy.model.Badi;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener{

    ArrayAdapter<Badi> badiAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_overview));
        addBadisToClickableList();
    }

    private void addBadisToClickableList() {
        ListView badis = findViewById(R.id.badiliste);
        badiAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        badiAdapter.addAll(BadiDao.getAll());
        badis.setAdapter(badiAdapter);

        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), BadiDetailsActivity.class);
                Badi selected = (Badi) parent.getItemAtPosition(position);

                intent.putExtra("badiId", selected.getId());
                intent.putExtra("badiName", selected.getName());
                startActivity(intent);
            }
        };

        badis.setOnItemClickListener(mListClickedHandler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    private void filterBadiAdapter(String filterString) {
        badiAdapter.getFilter().filter(filterString);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        filterBadiAdapter(s);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filterBadiAdapter(s);
        return false;
    }

}
package com.example.badiappflynnremy;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.badiappflynnremy.dal.BadiDao;
import com.example.badiappflynnremy.helper.WieWarmJsonParser;
import com.example.badiappflynnremy.model.Badi;
import com.example.badiappflynnremy.model.Becken;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayAdapter<Badi> badiAdapter;
    SearchView searchView;
    private static final String WIE_WARM_API_URL = "https://www.wiewarm.ch:443/api/v1/bad.json/";

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
        badis.setAdapter(badiAdapter);
        badiAdapter.addAll(BadiDao.getAll());


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

    public void getBadis(String url) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Badi badi = WieWarmJsonParser.createBadiFromJsonString(response);
                    badiAdapter.add(badi);
                } catch (JSONException e) {
                    generateAlertDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                generateAlertDialog();
            }
        });

        queue.add(stringRequest);
    }

    private void generateAlertDialog() {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {             // Closes this activity
                finish();
            }
        });
        dialogBuilder.setMessage("Die Badidetails konnten nicht geladen werden. Versuche es später nochmals.").setTitle("Fehler");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

}
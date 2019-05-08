package com.example.badiappflynnremy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.badiappflynnremy.helper.WieWarmJsonParser;
import com.example.badiappflynnremy.model.Badi;
import com.example.badiappflynnremy.model.Becken;

import org.json.JSONException;

public class BadiDetailsActivity extends AppCompatActivity {

    //Einzelansicht der Badi

    private int badiId;
    private ProgressBar progressBar;
    private Badi bad;
    private Double temperaturOrt;
    private String ort;
    private String information;

    //API URL Strings
    private static final String WIE_WARM_API_URL = "https://www.wiewarm.ch/api/v1/bad.json/";
    private static final String TEMPERATUR_API_URL = "https://api.apixu.com/v1/current.json?key=1cd7a946d4e64c6c8ec110345190605&q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badi_details);

        progressBar = findViewById(R.id.loading_badi_details_progress);

        Intent intent = getIntent();
        badiId = intent.getIntExtra("badiId", 0);
        String name = intent.getStringExtra("badiName");
        ort = intent.getStringExtra("ort");
        information = intent.getStringExtra("info");

        setTitle(name);
        progressBar.setVisibility(View.VISIBLE);

        getBadiTemp(WIE_WARM_API_URL + badiId);
        String JSONQueryUrl = generateUrl(ort);
        getLocationTemp(JSONQueryUrl);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView textView;
        textView = findViewById(R.id.ort_textview);
        textView.setText(ort);
        textView = findViewById(R.id.text_info);
        if (!information.isEmpty()) {
            textView.setText(information);
        }

        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BadiLocationActivity.class);

                intent.putExtra("badiId", bad.getId());
                intent.putExtra("badiName", bad.getName());
                intent.putExtra("badiOrt", bad.getOrt());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        getBadiTemp(WIE_WARM_API_URL + badiId);
        getLocationTemp(generateUrl(ort));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String generateUrl(String ort) {
        return TEMPERATUR_API_URL + ort;
    }

    //Temperaturen der Becken aus der Wiewarm-API holen und in Adapter füllen
    private void getBadiTemp(String url) {

        final ArrayAdapter<Becken> beckenInfosAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Badi badi = WieWarmJsonParser.createBadiFromJsonString(response);
                    bad = badi;
                    beckenInfosAdapter.addAll(badi.getBecken());
                    ListView badiInfoList = findViewById(R.id.badi_details_list);
                    badiInfoList.setAdapter(beckenInfosAdapter);
                    progressBar.setVisibility(View.GONE);
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

    //Die Temperatur des Ortes von apixu-API holen
    private void getLocationTemp(String url) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    temperaturOrt = WieWarmJsonParser.createOrtTempFromJsonString(response);
                    TextView temperaturView = findViewById(R.id.temperatur_textview);
                    temperaturView.setText(temperaturOrt + "°C");
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

    //Fehlermeldung wenn die Temperatur des Ortes nicht geholt werden konnte
    private void temperatureNotFoundDialog() {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {             // Closes this activity
                dialog.dismiss();
            }
        });
        dialogBuilder.setTitle(R.string.alert);
        dialogBuilder.setMessage(R.string.alert_description_locationtemperature);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    //Generelle Fehlermeldung
    private void generateAlertDialog() {
        progressBar.setVisibility(View.GONE);
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {             // Closes this activity
                finish();
            }
        });
        dialogBuilder.setMessage(R.string.alert_description_data_fail).setTitle(R.string.alert);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}

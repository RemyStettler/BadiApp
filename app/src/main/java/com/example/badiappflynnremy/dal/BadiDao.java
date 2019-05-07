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
        availableBadis.add(new Badi(71, "Schwimmbad", "BE", "Aarberg", "Keine Adresse vorhanden.", "Die Messdaten werden von Schweiz Tourismus (www.myswitzerland.com) zur Verfügung \r\ngestellt.\r\n\r\nAngaben ohne Gewähr.\r\n"));
        availableBadis.add(new Badi(27, "Schwimmbad Gruebi", "BE", "Adelboden", "Panorama-Schwimmbad Gruebi \r\nRisetensträssli", "Eröffnung Panorama Schwimmbad Gruebi Adelboden. \r\nSamstag, 11. Juni 2011 ab 09.00 Uhr"));
        availableBadis.add(new Badi(6, "Stadtberner Baeder", "BE", "Bern", "Sportamt der Stadt Bern \r\nEffingerstrasse 21 / Postfach 8125", "www.bern.ch/sportamt"));
        availableBadis.add(new Badi(55, "Schwimmbad Weiher", "ZH", "Seuzach", "Schwimmbad Weiher \r\nLandstr. 26", "Frühschwimmen:\r\nnur mit Saisonabo\r\nJuni / Juli / August\r\nMontag - Freitag 6.00 Uhr - 8.00Uhr\r\n\r\nSchwimmerbecken 33,333 Meter\r\nRutschbahn 72 Meter"));
        availableBadis.add(new Badi(7, "Badebetriebe Thun", "BE", "Thun", "Strandbad Thun \r\nStrandbadweg 10", "Beim täglichen Betriebsschluss gilt es zu beachten, dass die Badegäste 30 Minuten vorher nicht mehr ins Bad gelassen werden \r\nund 15 Minuten vor Betriebsschluss aus dem Wasser (See/Becken) müssen.\r\n\r\nWeitere Informationen unter: http://www.thun.ch/kultur-events/sport/badebetriebe"));
        availableBadis.add(new Badi(153, "Strandbad Bönigen", "BE", "Bönigen", "Strandbad \r\nLütschinenstrasse 24", ""));
        availableBadis.add(new Badi(219, "Freibad Langnau i.E.", "BE", "Langnau", "Freibad Langnau\r\nSchützenweg 235 / Moos", "Das Hallenbad wird in der Winterzeit jeden Dienstag auf 32°C geheizt. Dienstags während der Sommerzeit beträgt die Wassertemperatur 30°C\n(1. Mai bis 30. September).\nAn Feiertagen, welche auf einen Werktag fallen, ist Sonntagsbetrieb. Die Sauna ist an Feiertagen (werktags) folgend aufgeteilt:\nKleine Sauna = Damen\nGrosse Sauna = Herren"));
        availableBadis.add(new Badi(68, "Parkschwimmbad Lyss", "BE", "Lyss", "Parkschwimmbad \r\nWerdtstrasse 9", "Die Messdaten werden von Schweiz Tourismus (www.myswitzerland.com) zur Verfügung \r\ngestellt.\r\nAngaben ohne Gewähr.\r\n"));
        availableBadis.add(new Badi(129, "Parkbad Münsingen", "BE", "Münsingen", "Parkbad \r\n Belpbergstrasse 50", ""));

        return availableBadis;
    }
}

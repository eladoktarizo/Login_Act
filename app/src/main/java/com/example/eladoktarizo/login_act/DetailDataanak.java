package com.example.eladoktarizo.login_act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Elad Oktarizo on 14/05/2017.
 */

public class DetailDataanak extends AppCompatActivity {
    String noinduk,namaanak,tempatlahir,tanggallahir,hobi,citacita;
    EditText etnamaanak,ettlanak,ettempatlahiranak, ethobianak,etcitacitaanak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_anak);
        etnamaanak = (EditText)findViewById(R.id.ed_namaanak);
        ettempatlahiranak = (EditText) findViewById(R.id.ed_tempatlahiranak);
        ettlanak = (EditText)findViewById(R.id.ed_ttlanak);
        ethobianak = (EditText)findViewById(R.id.ed_hobianak);
        etcitacitaanak = (EditText)findViewById(R.id.ed_citacitaanak);

        Intent i = getIntent();

        noinduk = i.getStringExtra("id_anak");
        namaanak = i.getStringExtra("nama_anak");
        tempatlahir = i.getStringExtra("tempatlahir");
        tanggallahir = i.getStringExtra("tanggallahir");
        hobi = i.getStringExtra("hobi");
        citacita = i.getStringExtra("citacita");

        etnamaanak.setText(namaanak);
        ettempatlahiranak.setText(tempatlahir);
        ettlanak.setText(tempatlahir);
        ethobianak.setText(hobi);
        etcitacitaanak.setText(citacita);


    }
}

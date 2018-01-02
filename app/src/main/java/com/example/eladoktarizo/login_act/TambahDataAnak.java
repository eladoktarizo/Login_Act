package com.example.eladoktarizo.login_act;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Elad Oktarizo on 27/02/2017.
 */

public class TambahDataAnak extends AppCompatActivity implements View.OnClickListener {

    private EditText noindukanak;
    private EditText namaanak;
    private EditText ttlanak;
    private EditText hobianak;
    private EditText citacitaanak;
    AQuery aq;

    private Button buttontambahdataanak;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahdataanak_main);

        aq = new AQuery(getApplicationContext());
        noindukanak = (EditText) findViewById(R.id.noindukanak);
        namaanak = (EditText) findViewById(R.id.namaanak);
        ttlanak = (EditText) findViewById(R.id.ttlanak);
        hobianak = (EditText) findViewById(R.id.hobianak);
        citacitaanak = (EditText) findViewById(R.id.citacitaanak);
        buttontambahdataanak = (Button) findViewById(R.id.buttontambahdataanak);
        buttontambahdataanak.setOnClickListener(this);
    }

    private void TambahData() {
        final String nomorinduk = noindukanak.getText().toString().trim();
        final String nama = namaanak.getText().toString().trim();
        final String ttl = ttlanak.getText().toString().trim();
        final String hobi = hobianak.getText().toString().trim();
        final String citacita = citacitaanak.getText().toString().trim();
        final ProgressDialog loading;
        loading = ProgressDialog.show(TambahDataAnak.this,"Proses Kirim Data...","Wait...",false,false);

        HashMap<String,String> params = new HashMap<>();
        // Sesuaikan bagian ini dengan field di tabel Mahasiswa
        params.put(ConfigTambahDataAnak.KEY_EMP_NOMORINDUK, nomorinduk);
        params.put(ConfigTambahDataAnak.KEY_EMP_NAMA, nama);
        params.put(ConfigTambahDataAnak.KEY_EMP_TTL, ttl);
        params.put(ConfigTambahDataAnak.KEY_EMP_HOBI, hobi);
        params.put(ConfigTambahDataAnak.KEY_EMP_CITACITA, citacita);

        aq.ajax(ConfigSignup.URL_ADD,params,JSONObject.class,new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if (object != null) {
                    try {
                        if(object.getString("success").equals("1")){
                            loading.dismiss();
                            Toast.makeText(TambahDataAnak.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    loading.dismiss();
                    Toast.makeText(TambahDataAnak.this, status.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

       }
    // Methode untuk event penekanan Button
    @Override
    public void onClick(View v) {
        if(v == buttontambahdataanak){
            TambahData();
        }
    }
}
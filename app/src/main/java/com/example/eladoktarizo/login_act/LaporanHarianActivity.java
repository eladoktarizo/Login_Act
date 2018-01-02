package com.example.eladoktarizo.login_act;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
/**
 * Created by Elad Oktarizo on 27/02/2017.
 */

public class LaporanHarianActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText catatanguru;
    private EditText tanggallaporan;
    private Button savecatatan;
    private Button backmenu;
    AQuery aq;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulaporanharian_main);

        catatanguru = (EditText) findViewById(R.id.catatanguru);
        savecatatan = (Button) findViewById(R.id.savecatatan);
        backmenu = (Button) findViewById(R.id.backmenu);

        savecatatan.setOnClickListener(this);
    }

    private void SaveCatatan() {

        final String catatan = catatanguru.getText().toString().trim();
        final ProgressDialog loading;
        loading = ProgressDialog.show(LaporanHarianActivity.this, "Proses Simpan Data...", "Wait...", false, false);
        HashMap<String, String> params = new HashMap<>();


        aq.ajax(ConfigSignup.URL_ADD, params, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if (object != null) {
                    try {
                        if (object.getString("success").equals("1")) {
                            loading.dismiss();
                            Toast.makeText(LaporanHarianActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    loading.dismiss();
                    Toast.makeText(LaporanHarianActivity.this, status.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

   /* private void SaveCatatan() {

        final String catatan = catatanguru.getText().toString().trim();

        class SaveCatatan extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(LaporanHarianActivity.this, "Proses Menambahkan Catatan...","Silahkan Tunggu", false, false);
            }

            @Override
            protected void onPostExecute(String s){

                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(LaporanHarianActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();

                params.put(ConfigCatatan.KEY_EMP_CATATAN, catatan);
                RequestHadler rh = new RequestHadler();
                String res = rh.sendPostRequest(ConfigCatatan.URL_ADD, params);
                return res;
            }

        }

        SaveCatatan ae = new SaveCatatan();
        ae.execute();
    }*/
    }
    @Override
    public void onClick(View v) {
        if (v == savecatatan) {
            SaveCatatan();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MenuActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

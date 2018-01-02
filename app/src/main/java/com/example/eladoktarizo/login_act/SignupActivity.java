package com.example.eladoktarizo.login_act;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameortu;
    private EditText emailortu;
    private EditText passwordortu;
    private EditText namalengkaportu;
    private EditText alamatortu;
    private EditText notelportu;
    AQuery aq;
    private Button buttonpendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);
        aq = new AQuery(getApplicationContext());
        usernameortu = (EditText) findViewById(R.id.usernameortu);
        passwordortu = (EditText) findViewById(R.id.passwordortu);
        emailortu = (EditText) findViewById(R.id.emailortu);
        namalengkaportu = (EditText) findViewById(R.id.namalengkaportu);
        alamatortu = (EditText) findViewById(R.id.alamatortu);
        notelportu = (EditText) findViewById(R.id.notelportu);

        buttonpendaftaran = (Button) findViewById(R.id.buttondaftar);

        buttonpendaftaran.setOnClickListener(this);
    }

    private void registerUser(){
        final String username = usernameortu.getText().toString().trim();
        final String password = passwordortu.getText().toString().trim();
        final String email = emailortu.getText().toString().trim();
        final String namalengkap = namalengkaportu.getText().toString().trim();
        final String alamat = alamatortu.getText().toString().trim();
        final String nomortelepon = notelportu.getText().toString().trim();
        final ProgressDialog loading;
        loading = ProgressDialog.show(SignupActivity.this,"Proses Kirim Data...","Wait...",false,false);
        HashMap<String,String> params = new HashMap<>();
        // Sesuaikan bagian ini dengan field di tabel Mahasiswa
        params.put(ConfigSignup.KEY_EMP_USERNAME, username);
        params.put(ConfigSignup.KEY_EMP_PASSWORD, password);
        params.put(ConfigSignup.KEY_EMP_EMAIL, email);
        params.put(ConfigSignup.KEY_EMP_NAMALENGKAP, namalengkap);
        params.put(ConfigSignup.KEY_EMP_ALAMAT, alamat);
        params.put(ConfigSignup.KEY_EMP_NOMORTELEPON, nomortelepon);
        aq.ajax(ConfigSignup.URL_ADD,params,JSONObject.class,new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                if (object != null) {
                    try {
                        if(object.getString("success").equals("1")){
                            loading.dismiss();
                            Toast.makeText(SignupActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(i);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    loading.dismiss();
                    Toast.makeText(SignupActivity.this, status.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
       }
        //Creating a string request
 /*       StringRequest stringRequest = new StringRequest(Request.Method.POST, ConfigSignup.URL_ADD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(response.equalsIgnoreCase(Config.LOGIN_SUCCESS)){
                            loading.dismiss();
                            Toast.makeText(SignupActivity.this, "berhasil", Toast.LENGTH_LONG).show();
                        }else{
                            loading.dismiss();
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                        }
                        loading.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Adding parameters to request
                HashMap<String,String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(ConfigSignup.KEY_EMP_USERNAME, username);
                params.put(ConfigSignup.KEY_EMP_PASSWORD, password);
                params.put(ConfigSignup.KEY_EMP_EMAIL, email);
                params.put(ConfigSignup.KEY_EMP_NAMALENGKAP, namalengkap);
                params.put(ConfigSignup.KEY_EMP_ALAMAT, alamat);
                params.put(ConfigSignup.KEY_EMP_NOMORTELEPON, nomortelepon);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
 */
    // Methode untuk event penekanan Button
    @Override
    public void onClick(View v) {
        if(v == buttonpendaftaran){
            registerUser();
        }
    }
}
package com.example.eladoktarizo.login_act;

/**
 * Created by Elad Oktarizo on 27/02/2017.
 */

public class ConfigSignup {

    //Alamat URL tempat kita meletakkan script PHP di PC Server
    // Link untuk INSERT Data
    public static final String URL_ADD="http://192.168.1.19/monitoring/signup.php";
    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel Mahasiswa
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_USERNAME ="username" ;
    public static final String KEY_EMP_PASSWORD ="password" ;
    public static final String KEY_EMP_EMAIL ="email" ;
    public static final String KEY_EMP_NAMALENGKAP ="namalengkap" ;
    public static final String KEY_EMP_ALAMAT ="alamat" ;
    public static final String KEY_EMP_NOMORTELEPON ="nomortelepon" ;


    // Tags Format JSON
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_PASSWORD = "password";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_NAMALENGKAP = "namalengkap";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_NOMORTELEPON = "nomortelepon";
}

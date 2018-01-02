package com.example.eladoktarizo.login_act;

/**
 * Created by Elad Oktarizo on 27/02/2017.
 */

public class ConfigTambahDataAnak {

    //Alamat URL tempat kita meletakkan script PHP di PC Server
    // Link untuk INSERT Data
    public static final String URL_ADD="http://192.20.10.44/monitoring/dataanak.php";
    public static final String LIST_ANAK="http://192.20.10.44/monitoring/daftar_anak.php";
    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NOMORINDUK ="nomorinduk" ;
    public static final String KEY_EMP_NAMA ="nama" ;
    public static final String KEY_EMP_TTL ="ttl" ;
    public static final String KEY_EMP_HOBI ="hobi" ;
    public static final String KEY_EMP_CITACITA ="citacita" ;


    // Tags Format JSON
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NOMORINDUK = "nomorinduk";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_TTL = "ttl";
    public static final String TAG_HOBI = "hobi";
    public static final String TAG_CITACITA = "citacita";
}

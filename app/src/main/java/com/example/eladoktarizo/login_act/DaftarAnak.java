package com.example.eladoktarizo.login_act;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarAnak extends Fragment {

    AQuery aq;
    String url,email;
    ListView lv;
    ArrayList<HashMap<String,String>> dataList = new ArrayList<HashMap<String, String>>();
    public DaftarAnak() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_daftar_anak, container, false);
        lv = (ListView)root.findViewById(R.id.lv_dataanak) ;
/*        HashMap<String, String> user = new HashMap<String,String>();
        SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences(Config.SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        email = user.put(Config.KEY_EMAIL,sharedPreferences.getString(Config.KEY_EMAIL,null));*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String parseid = ((TextView)view.findViewById(R.id.id_anak)).getText().toString();
                String parsenama = ((TextView)view.findViewById(R.id.nama_anak)).getText().toString();
                String parsetempatlahir = ((TextView)view.findViewById(R.id.tempatlahir)).getText().toString();
                String parsetanggallahir = ((TextView)view.findViewById(R.id.tanggallahir)).getText().toString();
                String parsehobi = ((TextView)view.findViewById(R.id.hobi)).getText().toString();
                Intent i = new Intent(getActivity().getApplicationContext(),DetailDataanak.class);
                i.putExtra("id_anak",parseid);
                i.putExtra("nama_anak",parsenama);
                i.putExtra("tempatlahir",parsetempatlahir);
                i.putExtra("tanggallahir",parsetanggallahir);
                i.putExtra("hobi",parsehobi);
                startActivity(i);
            }
        });
        aq=new AQuery(getActivity().getApplicationContext());
        getData();
        return root;
    }

  public  void getData() {
            // Sesuaikan bagian ini dengan field di tabel Mahasiswa
        HashMap<String, String> params = new HashMap<>();
            params.put("email","eladoktarizo@gmail.com" );
            aq.ajax(ConfigTambahDataAnak.LIST_ANAK, params, JSONObject.class, new AjaxCallback<JSONObject>() {
                @Override
                public void callback(String url, JSONObject object, AjaxStatus status) {
                    if (object != null) {
                        try {
                            if (object.getString("success").equals("1")) {
                                JSONArray jsonArray = object.getJSONArray("daftar_anak");
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    HashMap<String,String>hm = new HashMap<String, String>();
                                    String namaanak = jsonObject.getString("namalengkap");
                                    String noinduk = jsonObject.getString("noinduk");
                                    String tempatlahir = jsonObject.getString("tempatlahir");
                                    String tanggallahir = jsonObject.getString("tanggallahir");
                                    String hobi = jsonObject.getString("hobi");
                                    hm.put("namalengkap",namaanak);
                                    hm.put("noinduk",noinduk);
                                    hm.put("tempatlahir",tempatlahir);
                                    hm.put("tanggallahir",tanggallahir);
                                    hm.put("hobi",hobi);
                                    dataList.add(hm);
                                }
                                ListAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(),dataList,
                                        R.layout.list_anak,new String[]{"namalengkap","noinduk","tempatlahir","tanggallahir","hobi"},
                                        new int[]{R.id.nama_anak,R.id.id_anak,R.id.tempatlahir,R.id.tanggallahir,R.id.hobi});
                                lv.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), status.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



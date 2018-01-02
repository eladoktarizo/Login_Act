package com.example.eladoktarizo.login_act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

public class editdataanak extends AppCompatActivity {
ActionMenuView amv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdataanak);
        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        amv = (ActionMenuView)findViewById(R.id.amvmenu);
        amv.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onOptionsItemSelected(item);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.editdataanak,amv.getMenu());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_edit) {
            // Handle the camera action
        } else if (id == R.id.nav_hapus) {

        }

        return true;
    }
}

package com.savar.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements RecyclerClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


        RecyclerView recycler = findViewById(R.id.recycler);

        ArrayList<String> names = new ArrayList<>();
        names.add("Home");
        names.add("About");
        names.add("Gallery");
        names.add("Learn");
        names.add("Education");
        names.add("Content");


        RecyclerAdapter adapter = new RecyclerAdapter(names,this );

        recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(String name) {
        Toast.makeText(this, name , Toast.LENGTH_SHORT).show();
    }
}

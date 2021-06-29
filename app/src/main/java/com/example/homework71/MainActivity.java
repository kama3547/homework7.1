package com.example.homework71;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceControl;

import com.example.homework71.fragmen.ListFragment;
import com.example.homework71.fragmen.MainFragment;
import com.example.homework71.fragmen.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.btn_main:
                        transaction.replace(R.id.container_fragment,new MainFragment()).commit();
                        item.setChecked(true);
                        break;
                    case R.id.btn_list:
                        transaction.replace(R.id.container_fragment,new ListFragment()).commit();
                        item.setChecked(true);
                        break;
                    case R.id.btn_prof:
                        transaction.replace(R.id.container_fragment, new ProfileFragment()).commit();
                        item.setChecked(true);
                        break;

                }
                return false;
            }
        });


    }
}
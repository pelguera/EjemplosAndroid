package com.pelme.ejemplotabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.pelme.ejemplotabs.adapters.PageAdapter;
import com.pelme.ejemplotabs.fragments.IngresoFragment;
import com.pelme.ejemplotabs.fragments.ListaFragment;
import com.pelme.ejemplotabs.modelo.Persona;


public class MainActivity extends AppCompatActivity implements IngresoFragment.personaInterface {

    private Toolbar tbPrincipal;
    private TabLayout tlPrincipal;
    private ViewPager vpPrincipal;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbPrincipal = (Toolbar) findViewById(R.id.tbPrincipal);
        setSupportActionBar(tbPrincipal);

        tlPrincipal = findViewById(R.id.tlPrincipal);
        tlPrincipal.addTab(tlPrincipal.newTab().setText("Tab 1"));
        tlPrincipal.addTab(tlPrincipal.newTab().setText("Tab 2"));

        vpPrincipal = findViewById(R.id.vpPrincipal);
        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tlPrincipal.getTabCount());
        vpPrincipal.setAdapter(pagerAdapter);
        vpPrincipal.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlPrincipal));

        tlPrincipal.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Seleccionado", Toast.LENGTH_LONG).show();
                int position = tab.getPosition();
                vpPrincipal.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Deseleccionado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Reseleccionado", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void addPersona(Persona persona) {
        ListaFragment listaFragment = (ListaFragment) getSupportFragmentManager().getFragments().get(1);
        listaFragment.addPersona(persona);
        this.vpPrincipal.setCurrentItem(1);
    }
}

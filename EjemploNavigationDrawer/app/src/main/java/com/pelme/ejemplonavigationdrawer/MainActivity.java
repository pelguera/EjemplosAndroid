package com.pelme.ejemplonavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.pelme.ejemplonavigationdrawer.fragments.MensajeFragment;
import com.pelme.ejemplonavigationdrawer.fragments.ListadoFragment;
import com.pelme.ejemplonavigationdrawer.fragments.NuevoFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigationView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.navMensaje:
                        fragment = new MensajeFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.navNuevo:
                        fragment = new NuevoFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.navListado:
                        fragment = new ListadoFragment();
                        fragmentTransaction = true;
                        break;
                }

                if(fragmentTransaction){
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenido, fragment).commit();
                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                    drawer.closeDrawers();
                }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

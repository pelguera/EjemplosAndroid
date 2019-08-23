package cibertec.dam1.getdog;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class ActivityDetalle extends AppCompatActivity {

    TabHost host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        host=findViewById(R.id.tabHost);
        host.setup();

        // tab1
        TabHost.TabSpec spec=host.newTabSpec("Información");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Información");
        host.addTab(spec);

        // tab2
        spec=host.newTabSpec("Contacto");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Contacto");
        host.addTab(spec);

    }

}

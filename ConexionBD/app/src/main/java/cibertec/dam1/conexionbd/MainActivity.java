package cibertec.dam1.conexionbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import cibertec.dam1.conexionbd.dao.ClientesDB;
import cibertec.dam1.conexionbd.modelos.Cliente;

public class MainActivity extends AppCompatActivity {

    private ClientesDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ClientesDB(this);

        Cliente cliente1 = new Cliente("Jaime","11111","jaime@mail.net");
        Cliente cliente2 = new Cliente("Juan","22222","juan@mail.net");
        Cliente cliente3 = new Cliente("Pedro","33333","pedro@mail.net");
        Cliente cliente4 = new Cliente("David","44444","david@mail.net");

        Log.i("---> Base de datos: ", "Insertando Clientes....");
        db.insertCliente(cliente1);
        db.insertCliente(cliente2);
        db.insertCliente(cliente3);
        db.insertCliente(cliente4);
        Log.i("---> Base de datos: ", "Mostrando Clientes....");
        mostrarClientesLog();

        Log.i("---> Base de datos: ", "Borrando Cliente con id 1....");
        db.deleteCliente(1);
        mostrarClientesLog();

        Log.i("---> Base de datos: ", "Cambiando el nombre de cliente2....");
        cliente2.setName("María");
        db.updateCliente(cliente2);
        mostrarClientesLog();

        Log.i("---> Base de datos: ", "Buscando datos de cliente....");
        Cliente cliente = new Cliente();
        cliente = db.buscarCliente("Juan");
        Log.i("---> Base de datos: ", "Los datos de pedro son: "+cliente.toString());

        Log.i("---> Base de datos: ", "Cambiando el nombre de Juan....");
        cliente.setName("Maria");
        db.updateCliente(cliente);
        mostrarClientesLog();

        //this.mostrarClientesLog();
    }

    private void mostrarClientesLog() {
        List list = db.loadClientes();

        for(Object cliente : list) {
            Log.i("---> Base de datos: ", cliente.toString());
        }
    }
}

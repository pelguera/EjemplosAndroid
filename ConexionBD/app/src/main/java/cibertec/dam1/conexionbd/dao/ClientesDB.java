package cibertec.dam1.conexionbd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cibertec.dam1.conexionbd.conexion.DBHelper;
import cibertec.dam1.conexionbd.modelos.Cliente;
import cibertec.dam1.conexionbd.utilitarios.Constantes;

public class ClientesDB {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ClientesDB(Context context) {
        dbHelper = new DBHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }
/*
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }
*/
    private void closeDB() {
        if(db!=null){
            db.close();
        }
    }

    // CRUD...

    private ContentValues clienteMapperContentValues(Cliente cliente) {
        ContentValues cv = new ContentValues();
        cv.put(Constantes.CLI_NOMBRE, cliente.getName());
        cv.put(Constantes.CLI_TELF, cliente.getTelf());
        cv.put(Constantes.CLI_MAIL, cliente.getMail());
        return cv;
    }

    public long insertCliente(Cliente cliente) {
        //this.openWriteableDB();
        db = dbHelper.getWritableDatabase();
        long rowID = db.insert(Constantes.TABLA_CLIENTES, null, clienteMapperContentValues(cliente));
        this.closeDB();

        return rowID;
    }

    public void updateCliente(Cliente cliente) {
        //this.openWriteableDB();
        db = dbHelper.getWritableDatabase();
        String where = Constantes.CLI_ID + "= ?";
        db.update(Constantes.TABLA_CLIENTES, clienteMapperContentValues(cliente), where, new String[]{String.valueOf(cliente.getId())});
        db.close();
    }

    public void deleteCliente(int id) {
        //this.openWriteableDB();
        db = dbHelper.getWritableDatabase();
        String where = Constantes.CLI_ID + "= ?";
        db.delete(Constantes.TABLA_CLIENTES, where, new String[]{String.valueOf(id)});
        this.closeDB();
    }

    public ArrayList loadClientes() {

        ArrayList list = new ArrayList<>();

        //this.openReadableDB();
        this.db = dbHelper.getReadableDatabase();
        String[] campos = new String[]{Constantes.CLI_ID, Constantes.CLI_NOMBRE, Constantes.CLI_TELF, Constantes.CLI_MAIL};
        Cursor c = db.query(Constantes.TABLA_CLIENTES, campos, null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                Cliente cliente = new Cliente();
                cliente.setId(c.getInt(0));
                cliente.setName(c.getString(1));
                cliente.setTelf(c.getString(2));
                cliente.setMail(c.getString(3));
                list.add(cliente);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }

    public Cliente buscarCliente(String nombre) {
        Cliente cliente = new Cliente();
        //this.openReadableDB();
        this.db = dbHelper.getReadableDatabase();
        String where = Constantes.CLI_NOMBRE + "= ?";
        String[] whereArgs = {nombre};
        Cursor c = db.query(Constantes.TABLA_CLIENTES, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            cliente.setId(c.getInt(0));
            cliente.setName(c.getString(1));
            cliente.setTelf(c.getString(2));
            cliente.setMail(c.getString(3));
            c.close();
        }
        this.closeDB();
        return cliente;
    }
    /*
    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Constantes.TABLA_CLIENTES_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
*/

}

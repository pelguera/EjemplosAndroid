package com.pelme.ejemplobbvasqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pelme.ejemplobbvasqlite.conexionBD.DBHelper;
import com.pelme.ejemplobbvasqlite.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UsuarioDAO(Context context) {
        this.dbHelper = new DBHelper(context, "BDUsuario", null, 1);
    }

    public long ingresarUsuario(Usuario usuario){
        this.db = this.dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("apellido", usuario.getApellido());
        cv.put("edad", usuario.getEdad());

        long rowID = this.db.insert("usuarios", null, cv);
        this.db.close();
        return rowID;
    }

    public List<Usuario> listarUsuario(){
        this.db = this.dbHelper.getReadableDatabase();
        String[] campos = new String[]{"nombre", "apellido", "edad"};
        Cursor cursor = db.query("usuarios", campos, null,
                                null, null, null, null);
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            while(cursor.moveToNext()){
                Usuario usu = new Usuario(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2));
                lista.add(usu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
            this.db.close();
        }
        return lista;
    }


}

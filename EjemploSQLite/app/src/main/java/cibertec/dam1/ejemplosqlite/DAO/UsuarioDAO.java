package cibertec.dam1.ejemplosqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cibertec.dam1.ejemplosqlite.ConexionBD.DBHelper;
import cibertec.dam1.ejemplosqlite.Modelo.Usuario;
import cibertec.dam1.ejemplosqlite.Utilitarios.Constantes;

public class UsuarioDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UsuarioDAO(Context context) {
        this.dbHelper = new DBHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    private ContentValues mappingContentValuesUsuario(Usuario usuario){
        ContentValues cv = new ContentValues();
        cv.put(Constantes.USU_EMAIL, usuario.getEmail());
        cv.put(Constantes.USU_NOMBRE, usuario.getNombre());
        cv.put(Constantes.USU_APELLIDO, usuario.getApellido());
        cv.put(Constantes.USU_PASSWORD, usuario.getPassword());

        return cv;

    }

    public long insertarUsuario(Usuario usu){
        this.db = this.dbHelper.getWritableDatabase();
        long rowId = this.db.insert(Constantes.TABLA_USUARIOS, null, this.mappingContentValuesUsuario(usu));
        this.db.close();
        return rowId;
    }


    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = null;
        this.db = this.dbHelper.getReadableDatabase();
        String[] campos = {Constantes.USU_EMAIL, Constantes.USU_NOMBRE, Constantes.USU_APELLIDO};
        Cursor c = this.db.query(Constantes.TABLA_USUARIOS, campos, null, null, null,null, null, null);

        try{
            lista = new ArrayList<Usuario>();

            while(c.moveToNext()){
                Usuario u = new Usuario();
                u.setEmail(c.getString(0));
                u.setNombre(c.getString(1));
                u.setApellido(c.getString(2));

                lista.add(u);
            }

        }catch(Exception e){

        }finally {
            c.close();
            this.db.close();
        }

        return lista;
    }


    public Usuario validarLogueo(Usuario usuario){
        Usuario usuLogueado = null;
        this.db = this.dbHelper.getReadableDatabase();
        String[] campos = {Constantes.USU_EMAIL, Constantes.USU_NOMBRE, Constantes.USU_APELLIDO};
        String where = Constantes.USU_EMAIL + " = ? AND " + Constantes.USU_PASSWORD + " = ?";
        String[] whereArgs = {usuario.getEmail(), usuario.getPassword()};
        Cursor c = this.db.query(Constantes.TABLA_USUARIOS, campos, where, whereArgs, null,null, null, null);

        try{
            if (c.moveToFirst()){
                usuLogueado = new Usuario();
                usuLogueado.setEmail(c.getString(0));
                usuLogueado.setNombre(c.getString(1));
                usuLogueado.setApellido(c.getString(2));

            }

        }catch(Exception e){
            return null;
        }finally {
            c.close();
            this.db.close();
        }

        return usuLogueado;
    }

}

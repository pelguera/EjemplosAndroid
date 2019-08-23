package cibertec.dam1.logueousuario.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cibertec.dam1.logueousuario.ConexionBD.DBHelper;
import cibertec.dam1.logueousuario.Modelo.Usuario;
import cibertec.dam1.logueousuario.Utilitarios.Constantes;

public class UsuarioDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UsuarioDAO(Context context) {
        this.dbHelper = new DBHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    private void closeDB() {
        if(db!=null){
            db.close();
        }
    }

    private ContentValues usuarioMapperContentValues(Usuario usuario){
        ContentValues cv = new ContentValues();
        cv.put(Constantes.USU_NOMBRE, usuario.getNombre());
        cv.put(Constantes.USU_APELLIDO, usuario.getApellido());
        cv.put(Constantes.USU_EMAIL, usuario.getEmail());
        cv.put(Constantes.USU_PASSWORD, usuario.getPassword());
        return cv;
    }

    public long registrarUsuario(Usuario usuario){
        this.db = this.dbHelper.getWritableDatabase();
        long rowId = this.db.insert(Constantes.TABLA_USUARIOS, null, this.usuarioMapperContentValues(usuario));
        this.closeDB();
        return rowId;
    }

    public Usuario validarLogueo(Usuario usuario){
        Usuario usu = null;
        this.db = dbHelper.getWritableDatabase();
        String[] columns = {Constantes.USU_ID, Constantes.USU_NOMBRE, Constantes.USU_APELLIDO};
        String where = Constantes.USU_EMAIL + " = ? and " + Constantes.USU_PASSWORD + " = ?";
        String[] whereArgs = {usuario.getEmail(), usuario.getPassword()};
        Cursor c =this.db.query(Constantes.TABLA_USUARIOS, columns, where, whereArgs, null, null, null);

        //if( c != null || c.getCount() <=0) {
        if(c.moveToFirst()) {

            usu = new Usuario();
            usu.setId(c.getInt(0));
            usu.setNombre(c.getString(1));
            usu.setApellido(c.getString(2));
            c.close();
        }else{
            return null;
        }
        this.closeDB();
        return usu;
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = null;
        this.db = dbHelper.getReadableDatabase();
        String[] campos = new String[]{Constantes.USU_EMAIL, Constantes.USU_NOMBRE, Constantes.USU_APELLIDO};
        Cursor c = this.db.query(Constantes.TABLA_USUARIOS, campos, null, null, null, null, null);

        try{
            lista = new ArrayList<Usuario>();
            while(c.moveToNext()){
                Usuario u = new Usuario();
                u.setEmail(c.getString(0));
                u.setNombre(c.getString(1));
                u.setApellido(c.getString(2));
                lista.add(u);
            }
        }catch (Exception e){

        }finally {
            c.close();
        }
        this.closeDB();
        return lista;
    }

}

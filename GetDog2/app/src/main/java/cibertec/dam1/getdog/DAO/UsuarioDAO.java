package cibertec.dam1.getdog.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cibertec.dam1.getdog.ConexionBD.DBHelper;
import cibertec.dam1.getdog.Modelo.Usuario;
import cibertec.dam1.getdog.Utilitarios.Constantes;

public class UsuarioDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UsuarioDAO(Context context){
        this.dbHelper = new DBHelper(context,
                Constantes.DB_NAME,
                null,
                Constantes.DB_VERSION);
    }

    private ContentValues usuarioMapperContentValues(Usuario usuario){
        ContentValues cv = new ContentValues();
        cv.put(Constantes.USU_NOMBRE, usuario.getNombre());
        cv.put(Constantes.USU_APELLIDO, usuario.getApellido());
        cv.put(Constantes.USU_EMAIL, usuario.getEmail());
        cv.put(Constantes.USU_PASSWORD, usuario.getPassword());

        return cv;
    }

    public long registrarUsuario(Usuario u){
        this.db = this.dbHelper.getWritableDatabase(); // para registrar
        long rowId = this.db.insert(Constantes.TABLA_USUARIOS, //sentencia
                null,
                this.usuarioMapperContentValues(u));

        return rowId;
    }

    public Usuario validarUsuario(Usuario usuario){
        Usuario u=new Usuario();
        this.db=this.dbHelper.getReadableDatabase();
        String[] campos={Constantes.USU_EMAIL,Constantes.USU_NOMBRE,Constantes.USU_APELLIDO};

        String where=Constantes.USU_EMAIL +" = ? AND " + Constantes.USU_PASSWORD + " =?";

        String[] whereArgs={usuario.getEmail(),usuario.getPassword()};

        Cursor c=this.db.query(Constantes.TABLA_USUARIOS,campos,where,whereArgs,null,null,null,null);

        if(c.moveToNext()){
            u.setEmail(c.getString(0));
            u.setNombre(c.getString(1));
            u.setApellido(c.getString(2));

            c.close();
        }else {
            return null;
        }
        this.db.close();

        return u;
    }


}

package cibertec.dam1.el02t5bm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cibertec.dam1.el02t5bm.conexionBD.DBHelper;
import cibertec.dam1.el02t5bm.modelo.Alumno;
import cibertec.dam1.el02t5bm.utils.Constantes;

public class AlumnoDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public AlumnoDAO(Context context){
        this.dbHelper = new DBHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }


    private ContentValues mappingAlumnos(Alumno alumno){
        ContentValues cv = new ContentValues();
        cv.put(Constantes.ALU_NOMBRE, alumno.getNombre());
        cv.put(Constantes.ALU_APELLIDO, alumno.getApellido());
        cv.put(Constantes.ALU_NIVEL, alumno.getNivel());
        cv.put(Constantes.ALU_GRADO, alumno.getGrado());
        return cv;
    }

    public long insertarAlumno(Alumno alu){
        long rowId = 0;
        this.db = this.dbHelper.getWritableDatabase();
        rowId = db.insert(Constantes.TABLA_ALUMNOS, null, this.mappingAlumnos(alu));
        this.db.close();
        return rowId;
    }

    public List<Alumno> listarAlumnos(){
        List<Alumno> lista = null;
        this.db = this.dbHelper.getReadableDatabase();
        String[] campos = new String[]{Constantes.ALU_NOMBRE, Constantes.ALU_APELLIDO, Constantes.ALU_NIVEL, Constantes.ALU_GRADO};
        Cursor c = db.query(Constantes.TABLA_ALUMNOS, campos,null, null, null, null, null);

        try{
            lista = new ArrayList<Alumno>();
            while(c.moveToNext()){
                Alumno empleado = new Alumno(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3)
                );
                lista.add(empleado);
            }

        }catch(Exception e){
            return null;
        }finally {
            c.close();
            this.db.close();
        }

        return lista;
    }

}

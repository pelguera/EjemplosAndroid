package cibertec.dam1.el02_t5am.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cibertec.dam1.el02_t5am.Utils.Constantes;
import cibertec.dam1.el02_t5am.conexionBD.DBHelper;
import cibertec.dam1.el02_t5am.modelo.Empleado;

public class EmpleadoDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public EmpleadoDAO(Context context){
        this.dbHelper = new DBHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    private ContentValues mappingEmpleados(Empleado empleado){
        ContentValues cv = new ContentValues();
        cv.put(Constantes.EMP_NOMBRE, empleado.getNombre());
        cv.put(Constantes.EMP_APELLIDO, empleado.getApellido());
        cv.put(Constantes.EMP_AREA, empleado.getArea());
        cv.put(Constantes.EMP_CARGO, empleado.getCargo());
        return cv;
    }

    public long insertarEmpleado(Empleado emp){
        long rowId = 0;
        this.db = this.dbHelper.getWritableDatabase();
        rowId = db.insert(Constantes.TABLA_EMPLEADOS, null, this.mappingEmpleados(emp));
        this.db.close();
        return rowId;
    }

    public List<Empleado> listarEmpleados(){
        List<Empleado> lista = null;
        this.db = this.dbHelper.getReadableDatabase();
        String[] campos = new String[]{Constantes.EMP_NOMBRE, Constantes.EMP_APELLIDO, Constantes.EMP_AREA, Constantes.EMP_CARGO};
        Cursor c = db.query(Constantes.TABLA_EMPLEADOS, campos,null, null, null, null, null);

        try{
            lista = new ArrayList<Empleado>();
            while(c.moveToNext()){
                Empleado empleado = new Empleado(
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

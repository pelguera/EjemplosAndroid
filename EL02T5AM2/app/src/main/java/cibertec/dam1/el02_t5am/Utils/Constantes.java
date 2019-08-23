package cibertec.dam1.el02_t5am.Utils;

public class Constantes {

    public static final String DB_NAME = "database.db";
    public static final int DB_VERSION = 1;

    //TABLA EMPLEADOS
    public static final String TABLA_EMPLEADOS = "empleados";

    public static final String EMP_ID = "_id";
    public static final String EMP_NOMBRE = "nombre";
    public static final String EMP_APELLIDO = "apellido";
    public static final String EMP_AREA = "area";
    public static final String EMP_CARGO = "cargo";

    public static final String TABLA_EMPLEADOS_SQL =
            "CREATE TABLE IF NOT EXISTS " + TABLA_EMPLEADOS + "(" +
                    EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EMP_NOMBRE + " TEXT NOT NULL," +
                    EMP_APELLIDO   + " TEXT NOT NULL," +
                    EMP_AREA   + " TEXT, " +
                    EMP_CARGO + " TEXT);";

}

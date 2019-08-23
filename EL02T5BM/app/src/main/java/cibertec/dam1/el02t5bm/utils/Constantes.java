package cibertec.dam1.el02t5bm.utils;

public class Constantes {

    public static final String DB_NAME = "database.db";
    public static final int DB_VERSION = 1;

    //TABLA ALUMNOS
    public static final String TABLA_ALUMNOS = "alumnos";

    public static final String ALU_ID = "_id";
    public static final String ALU_NOMBRE = "nombre";
    public static final String ALU_APELLIDO = "apellido";
    public static final String ALU_NIVEL = "nivel";
    public static final String ALU_GRADO = "grado";

    public static final String TABLA_ALUMNOS_SQL =
            "CREATE TABLE IF NOT EXISTS " + TABLA_ALUMNOS + "(" +
                    ALU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ALU_NOMBRE + " TEXT NOT NULL," +
                    ALU_APELLIDO   + " TEXT NOT NULL," +
                    ALU_NIVEL   + " TEXT, " +
                    ALU_GRADO + " TEXT);";

}

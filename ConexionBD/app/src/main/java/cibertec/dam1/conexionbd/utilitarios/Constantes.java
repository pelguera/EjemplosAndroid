package cibertec.dam1.conexionbd.utilitarios;

public class Constantes {

    public static final String DB_NAME = "database.db";
    public static final int DB_VERSION = 1;

    //TABLA CLIENTES
    public static final String TABLA_CLIENTES = "clientes";

    public static final String CLI_ID = "_id";
    public static final String CLI_NOMBRE = "nombre";
    public static final String CLI_TELF = "telefono";
    public static final String CLI_MAIL = "email";

    public static final String TABLA_CLIENTES_SQL =
            "CREATE TABLE  " + TABLA_CLIENTES + "(" +
                    CLI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    CLI_NOMBRE + " TEXT NOT NULL," +
                    CLI_TELF   + " TEXT," +
                    CLI_MAIL   + " TEXT);" ;
}

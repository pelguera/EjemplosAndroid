package cibertec.dam1.getdog.Utilitarios;

public class Constantes {

    public static final String DB_NAME = "database.db";
    public static final int DB_VERSION = 1;

    //Tabla Usuario
    public static final String TABLA_USUARIOS = "usuarios";
    public static final String USU_ID = "id";
    public static final String USU_NOMBRE = "nombre";
    public static final String USU_APELLIDO = "apellido";
    public static final String USU_EMAIL = "email";
    public static final String USU_PASSWORD = "password";

    public static final String TABLA_USUARIO_SQL =
            "CREATE TABLE usuarios " +
                    "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nombre TEXT," +
                    " apellido TEXT," +
                    " email TEXT NOT NULL, " +
                    " password TEXT);";
}

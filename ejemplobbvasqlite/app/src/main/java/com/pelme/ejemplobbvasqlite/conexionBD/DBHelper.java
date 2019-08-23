package com.pelme.ejemplobbvasqlite.conexionBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLA_USUARIO_SQL =
            "CREATE TABLE IF NOT EXISTS usuarios " +
                    "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nombre TEXT NOT NULL, " +
                    " apellido TEXT," +
                    " edad TEXT);";


    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIO_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.talentounido.persistencia.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "dbAbarrotes";
    private static final int DATA_BASE_VERSION= 1;

    private static final String CREATE_TABLE = "create table productos(" +
            "codigo integer primary key not null, " +
            "marca text, " +
            "fecha text, " +
            "compra double, " +
            "venta double, " +
            "descripcion text, " +
            "existencia integer," +
            "stock integer)";
    public Helper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL(CREATE_TABLE);
    }
}

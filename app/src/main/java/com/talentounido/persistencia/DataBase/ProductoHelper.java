package com.talentounido.persistencia.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductoHelper extends SQLiteOpenHelper {
    public ProductoHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
String crear = "CREATE TABLE PRODUCTO (codigo INTEGER PRIMARY KEY NOT NULL, marca TEXT, vencimiento DATE, compra DOUBLE, venta DOUBLE, " +
        "descripcion TEXT, existencias INTEGER, stock INTEGER)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        db.execSQL(crear);
    }
}

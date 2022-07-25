package com.talentounido.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.talentounido.persistencia.DataBase.Helper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAgregar,btnConsultar;
    private EditText etCodigo,etMarca,etCaducidad,etPrecioCompra,etPrecioVenta,etDescripcion,etExistencia,etStock;

    private SQLiteDatabase db;
    private Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new Helper(this);
        db = helper.getWritableDatabase();

        variables();
        datePicker();;
        consultData();
        insertData();
    }
    private void datePicker(){
    etCaducidad.setOnClickListener(v -> {
        final Calendar c = Calendar.getInstance();
        int year,month,day;

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int y, int m, int d) {
                etCaducidad.setText(y+"/"+dosDigitos(m)+"/"+dosDigitos(d));
            }
        },year,month,day);
        dialog.show();
    });
}
    private void consultData() {
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Listado.class);
               startActivity(intent);
            }
        });
    }

    private void insertData() {
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo,marca,fecha,descripcion;
                Double compra,venta;
                int existencia,stock;


                  codigo = etCodigo.getText().toString();
                  marca = etMarca.getText().toString();
                  fecha = etCaducidad.getText().toString();
                  compra =Double.valueOf(etPrecioCompra.getText().toString());
                  venta = Double.valueOf(etPrecioVenta.getText().toString());
                  descripcion = etDescripcion.getText().toString();
                  existencia = Integer.parseInt(etExistencia.getText().toString());
                  stock = Integer.parseInt(etStock.getText().toString());

                try {
                    if (db != null){
                        ContentValues values = new ContentValues();
                        values.put("codigo", codigo);
                        values.put("marca",marca );
                        values.put("fecha", fecha);
                        values.put("compra",compra );
                        values.put("venta", venta);
                        values.put("descripcion",descripcion );
                        values.put("existencia", existencia);
                        values.put("stock", stock);

                        long newRowId = db.insert("productos",null,values);
                        Toast.makeText(MainActivity.this, "Registro agregado correctamente " + newRowId, Toast.LENGTH_SHORT).show();
                        cleanEdits();
                    }else{
                        Toast.makeText(MainActivity.this, "Algo pas� con la conex�n", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error -> "+ e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String dosDigitos(int m) {
        String n;
        if (m<=9)
        {
        n = "0"+m;
        }else{
            n = String.valueOf(m);
        }
        return n;
    }
    private void variables(){
        btnAgregar = findViewById(R.id.btnAgregar);
        btnConsultar = findViewById(R.id.btnConsultar);

        etCodigo = findViewById(R.id.etCodigo);
        etMarca = findViewById(R.id.etMarca);
        etCaducidad = findViewById(R.id.etCaducidad);
        etPrecioCompra = findViewById(R.id.etPrecioCompra);
        etPrecioVenta = findViewById(R.id.etPrecioVenta);
        etDescripcion = findViewById(R.id.etDescripcion);
        etExistencia = findViewById(R.id.etExistencias);
        etStock = findViewById(R.id.etStock);
    }
    private void cleanEdits()
    {
        etCodigo.setText("");
        etMarca.setText("");
        etCaducidad.setText("");
        etPrecioCompra.setText("");
        etPrecioVenta.setText("");
        etDescripcion.setText("");
        etExistencia.setText("");
        etStock.setText("");
    }

}
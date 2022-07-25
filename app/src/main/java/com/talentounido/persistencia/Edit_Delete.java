package com.talentounido.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.talentounido.persistencia.DataBase.Helper;

public class Edit_Delete extends AppCompatActivity {
    private Button btnEditar,btnEliminar;
    private EditText etCodigo,etMarca,etCaducidad,etPrecioCompra,etPrecioVenta,etDescripcion,etExistencia,etStock;

    String codigo,marca,fecha,descripcion;
    double compra,venta;
    int existencia,stock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        variables();
        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            codigo= bundle.getString("codigo");
            marca = bundle.getString("marca");
            fecha= bundle.getString("fecha");
            compra = bundle.getDouble("compra");
            venta= bundle.getDouble("venta");
            descripcion = bundle.getString("descripcion");
            existencia= bundle.getInt("existencia");
            stock = bundle.getInt("stock");
        }

        etCodigo.setText(codigo);
        etMarca.setText(marca);
        etCaducidad.setText(fecha);
        etPrecioCompra.setText(String.valueOf(compra));
        etPrecioVenta.setText(String.valueOf(venta));
        etDescripcion.setText(descripcion);
        etExistencia.setText(String.valueOf(existencia));
        etStock.setText(String.valueOf(stock));


        btnEditar.setOnClickListener(v -> {
            marca  = etMarca.getText().toString();
            fecha = etCaducidad.getText().toString();
            compra =Double.parseDouble(etPrecioCompra.getText().toString());
            venta =Double.parseDouble(etPrecioVenta.getText().toString());
            descripcion=etDescripcion.getText().toString();
            existencia=Integer.parseInt(etExistencia.getText().toString());
            stock= Integer.parseInt(etStock.getText().toString());
            modificar(codigo,marca,fecha,compra,venta,descripcion,existencia,stock);

            Toast.makeText(Edit_Delete.this, "Registro Actualizado con exito", Toast.LENGTH_SHORT).show();
            onBackPressed();
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(codigo);
                Toast.makeText(Edit_Delete.this, "Registro eliminado" , Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }


    private void delete(String codigo)
    {
        Helper helper = new Helper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "delete from productos where codigo="+codigo;
        db.execSQL(sql);
        db.close();
    }
    private void modificar(String codigo,String marca, String fecha, double compra, double venta, String descripcion, int existencia, int stock)
    {
        Helper helper = new Helper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "update productos set marca='"+marca+"', fecha='"+fecha+"', " +
                "compra="+compra+", venta="+venta+", descripcion='"+descripcion+"', existencia="+existencia+", stock="+stock+" where codigo= " +
                ""+codigo;

        db.execSQL(sql);
        db.close();
    }
    private void variables(){
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);

        etCodigo = findViewById(R.id.et_Codigo);
        etMarca = findViewById(R.id.et_Marca);
        etCaducidad = findViewById(R.id.et_Caducidad);
        etPrecioCompra = findViewById(R.id.et_PrecioCompra);
        etPrecioVenta = findViewById(R.id.et_PrecioVenta);
        etDescripcion = findViewById(R.id.et_Descripcion);
        etExistencia = findViewById(R.id.et_Existencias);
        etStock = findViewById(R.id.et_Stock);
    }
}
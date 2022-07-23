package com.talentounido.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAgregar,btnConsultar;
    private EditText etCodigo,etMarca,etCaducidad,etPrecioCompra,etPrecioVenta,etDescripcion,etExistencia,etStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        variables();

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
}
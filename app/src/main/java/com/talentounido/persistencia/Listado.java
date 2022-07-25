package com.talentounido.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.talentounido.persistencia.DataBase.Helper;
import com.talentounido.persistencia.Estructura.Adaptador;
import com.talentounido.persistencia.Estructura.Producto;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    private ListView lstlista;
    private Adaptador adaptador;
    ArrayList<Producto> lista;

    private SQLiteDatabase db;
    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        helper = new Helper(this);
        db = helper.getReadableDatabase();

        lstlista = findViewById(R.id.lstLista);
        lista = new ArrayList<>();
        lista.addAll(getLista());
        adaptador = new Adaptador(this,lista,R.layout.list_item);
        lstlista.setAdapter(adaptador);
        clickItem();

    }
    private void clickItem()
    {
        lstlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo,marca,fecha,descripcion;
                Double compra,venta;
                int existencia,stock;

                codigo = lista.get(position).getCodigo();
                marca = lista.get(position).getMarca();
                fecha = lista.get(position).getFecha();
                compra = lista.get(position).getPreCompra();
                venta = lista.get(position).getPreVenta();
                descripcion = lista.get(position).getDescripcion();
                existencia = lista.get(position).getExistencia();
                stock = lista.get(position).getStock();


                Intent intent= new Intent(Listado.this,Edit_Delete.class);
                intent.putExtra("codigo",codigo);
                intent.putExtra("marca",marca);
                intent.putExtra("fecha",fecha);
                intent.putExtra("compra",compra);
                intent.putExtra("venta",venta);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("existencia",existencia);
                intent.putExtra("stock",stock);
                startActivity(intent);
            }
        });
    }
    private List<Producto> getLista(){

        Cursor c = db.query("productos",null,null,null,null,null,null);
        List<Producto> lista = new ArrayList<Producto>();

            while(c.moveToNext())
            {
                String codigo,marca,fecha,descripcion;
                double compra,venta;
                int existencia,stock;

                codigo = c.getString(0);
                marca = c.getString(1);
                fecha = c.getString(2);
                compra = c.getDouble(3);
                venta = c.getDouble(4);
                descripcion = c.getString(5);
                existencia = c.getInt(6);
                stock = c.getInt(7);

                lista.add(new Producto(codigo,marca,fecha,compra,venta,descripcion,existencia,stock));
            }
        return lista;
    }
}
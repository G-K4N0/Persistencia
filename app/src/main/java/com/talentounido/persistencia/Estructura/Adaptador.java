package com.talentounido.persistencia.Estructura;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.talentounido.persistencia.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Producto> productos;
    private Context context;
    private int layout;
    public Adaptador(ArrayList<Producto> productos, Context context, int layout) {
        this.productos = productos;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {return this.productos.size();}

    @Override
    public Object getItem(int position) {return this.productos.get(position);}

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        view = inflater.inflate(R.layout.list_item,null);

        String marca,venta,existencia;
        marca = productos.get(position).getMarca();
        venta = productos.get(position).getPreVenta().toString();
        existencia = String.valueOf(productos.get(position).getExistencia());

        EditText txtMarca,txtVenta,txtExistencia;
        txtMarca = view.findViewById(R.id.txtMarca);
        txtVenta = view.findViewById(R.id.txtVenta);
        txtExistencia = view.findViewById(R.id.txtExistencia);

        txtMarca.setText(marca);
        txtVenta.setText(venta);
        txtExistencia.setText(existencia);

        return view;
    }
}

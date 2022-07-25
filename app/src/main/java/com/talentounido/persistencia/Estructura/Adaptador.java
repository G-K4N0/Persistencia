package com.talentounido.persistencia.Estructura;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.talentounido.persistencia.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> productos;
    private int layout;

    public Adaptador(Context context, ArrayList<Producto> productos, int layout) {
        this.context = context;
        this.productos = productos;
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
        View v = convertView;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.list_item,null);

        String marca,venta,existencia;
        marca = productos.get(position).getMarca().toString();
        venta = productos.get(position).getPreVenta().toString();
        existencia = String.valueOf(productos.get(position).getExistencia());

        TextView txtMarca,txtVenta,txtExistencia;
        txtMarca = v.findViewById(R.id.txtMarca);
        txtVenta = v.findViewById(R.id.txtVenta);
        txtExistencia = v.findViewById(R.id.txtExistencia);

        txtMarca.setText(marca);
        txtVenta.setText(venta);
        txtExistencia.setText(existencia);

        return v;
    }
}

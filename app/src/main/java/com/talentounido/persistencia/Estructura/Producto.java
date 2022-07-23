package com.talentounido.persistencia.Estructura;

public class Producto {
    private String codigo;
    private String marca;
    private String vencimiento;
    private Double preCompra;
    private Double preVenta;
    private String descripcion;
    private int existencia;
    private int stock;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Double getPreCompra() {
        return preCompra;
    }

    public void setPreCompra(Double preCompra) {
        this.preCompra = preCompra;
    }

    public Double getPreVenta() {
        return preVenta;
    }

    public void setPreVenta(Double preVenta) {
        this.preVenta = preVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto(String codigo, String marca, String vencimiento, Double preCompra, Double preVenta, String descripcion, int existencia, int stock) {
        this.codigo = codigo;
        this.marca = marca;
        this.vencimiento = vencimiento;
        this.preCompra = preCompra;
        this.preVenta = preVenta;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.stock = stock;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_proyect;

/**
 *
 * @author Camilo Gallego B
 */
public class Inventario {
    private int cod_producto;
    private String nombre;
    private String descripcion;
    private double precio_base;
    private double precio_venta;
    private String categoria;
    private int cantidad_disponible;
    
    public Inventario(int cod_producto, String nombre, String descripcion, double precio_base,
                      double precio_venta, String categoria, int cantidad_disponible){
        this.cod_producto = cod_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_base = precio_base;
        this.precio_venta = precio_venta;
        this.categoria = categoria;
        this.cantidad_disponible = cantidad_disponible;
    }
    
    public int getcod_producto(){
        return cod_producto;
    }
    public void setcod_producto(int cod_producto){
        this.cod_producto = cod_producto;
    }
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public String getdescripcion(){
        return descripcion;
    }
    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public double getprecio_base(){
        return precio_base;
    }
    public void setprecio_base(double precio_base){
        this.precio_base = precio_base;
    }
    public double getprecio_venta(){
        return precio_venta;
    }
    public void setprecio_venta(double precio_venta){
        this.precio_venta = precio_venta;
    }
    public String getcategoria(){
        return categoria;
    }
    public void setcategoria(String categoria){
        this.categoria = categoria;
    }
    public int getcantidad_disponible (){
        return cantidad_disponible;
    }
    public void setcantidad_disponible(int cantidad_disponible){
        this.cantidad_disponible = cantidad_disponible;
    }
}

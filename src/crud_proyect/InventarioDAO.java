/*    
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud_proyect;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Camilo Gallego B
 */
public class InventarioDAO {
    public boolean agregarProducto(Inventario inventario) {
        String sql = "INSERT INTO inventario (cod_producto, nombre, descripcion, precio_base, precio_venta, categoria, cantidad_disponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, inventario.getcod_producto());
            pstmt.setString(2, inventario.getnombre());
            pstmt.setString(3, inventario.getdescripcion());
            pstmt.setDouble(4, inventario.getprecio_base());
            pstmt.setDouble(5, inventario.getprecio_venta());
            pstmt.setString(6, inventario.getcategoria());
            pstmt.setInt(7, inventario.getcantidad_disponible());

            pstmt.executeUpdate();
            conn.commit(); // Realizar commit explícito
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Inventario obtenerProducto(int codProducto) {
        String sql = "SELECT * FROM inventario WHERE cod_producto = ?";
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codProducto);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Inventario(
                    rs.getInt("cod_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_base"),
                    rs.getDouble("precio_venta"),
                    rs.getString("categoria"),
                    rs.getInt("cantidad_disponible")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Inventario> obtenerTodosLosProductos() {
        List<Inventario> inventarioList = new ArrayList<>();
        String sql = "SELECT * FROM inventario";
        try (Connection conn = new Conexion().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                inventarioList.add(new Inventario(
                        rs.getInt("cod_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio_base"),
                        rs.getDouble("precio_venta"),
                        rs.getString("categoria"),
                        rs.getInt("cantidad_disponible")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventarioList;
    }
    public boolean actualizarProducto(Inventario inventario) {
        String sql = "UPDATE inventario SET nombre = ?, descripcion = ?, precio_base = ?, precio_venta = ?, categoria = ?, cantidad_disponible = ? WHERE cod_producto = ?";
        try (Connection conn = new Conexion().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, inventario.getnombre());
            pstmt.setString(2, inventario.getdescripcion());
            pstmt.setDouble(3, inventario.getprecio_base());
            pstmt.setDouble(4, inventario.getprecio_venta());
            pstmt.setString(5, inventario.getcategoria());
            pstmt.setInt(6, inventario.getcantidad_disponible());
            pstmt.setInt(7, inventario.getcod_producto());

             int filasActualizadas = pstmt.executeUpdate();
            conn.commit(); 

            if (filasActualizadas > 0) {
                System.out.println("Producto actualizado exitosamente.");
                 return true;
            } else {
                System.out.println("No se encontró el producto con el código proporcionado.");
                return false;
            }} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean eliminarProducto(int codProducto) {
    String sql = "DELETE FROM inventario WHERE cod_producto = ?";
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = new Conexion().getConnection();
        conn.setAutoCommit(false); 

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, codProducto);

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Producto eliminado exitosamente.");
            conn.commit(); 
            return true;
        } else {
            System.out.println("No se encontró el producto con el código especificado.");
            conn.rollback(); 
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        try {
            if (conn != null) {
                conn.rollback(); 
            }
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        return false;
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close(); 
            }
            if (conn != null) {
                conn.close(); 
            }
        } catch (SQLException closeEx) {
            closeEx.printStackTrace();
        }
    }
}
}

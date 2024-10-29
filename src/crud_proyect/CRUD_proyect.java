/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud_proyect;
import java.util.Scanner;
/**
 *
 * @author Camilo Gallego B
 */
public class CRUD_proyect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InventarioDAO inventarioDAO = new InventarioDAO();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Consultar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("Ingrese código del producto: ");
                    int codProducto = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese descripción del producto: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Ingrese precio base: ");
                    double precioBase = scanner.nextDouble();

                    System.out.print("Ingrese precio de venta: ");
                    double precioVenta = scanner.nextDouble();

                    System.out.print("Ingrese categoría del producto: ");
                    String categoria = scanner.next();

                    System.out.print("Ingrese cantidad disponible: ");
                    int cantidadDisponible = scanner.nextInt();

                    Inventario nuevoProducto = new Inventario(codProducto, nombre, descripcion, precioBase, precioVenta, categoria, cantidadDisponible);
                    if (inventarioDAO.agregarProducto(nuevoProducto)) {
                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("Error al agregar el producto.");
                    }
                    break;

                case 2:
                    // Consultar producto
                    System.out.print("Ingrese código del producto a consultar: ");
                    int codConsulta = scanner.nextInt();
                    Inventario producto = inventarioDAO.obtenerProducto(codConsulta);
                    if (producto != null) {
                        System.out.println("Producto encontrado: ");
                        System.out.println("Código: " + producto.getcod_producto());
                        System.out.println("Nombre: " + producto.getnombre());
                        System.out.println("Descripción: " + producto.getdescripcion());
                        System.out.println("Precio Base: " + producto.getprecio_base());
                        System.out.println("Precio Venta: " + producto.getprecio_venta());
                        System.out.println("Categoría: " + producto.getcategoria());
                        System.out.println("Cantidad Disponible: " + producto.getcantidad_disponible());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    // Actualizar producto
                    System.out.print("Ingrese código del producto a actualizar: ");
                    int codActualizar = scanner.nextInt();
                    Inventario productoActualizar = inventarioDAO.obtenerProducto(codActualizar);

                    if (productoActualizar != null) {
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Ingrese nuevo nombre del producto: ");
                        productoActualizar.setnombre(scanner.nextLine());

                        System.out.print("Ingrese nueva descripción del producto: ");
                        productoActualizar.setdescripcion(scanner.nextLine());

                        System.out.print("Ingrese nuevo precio base: ");
                        productoActualizar.setprecio_base(scanner.nextDouble());

                        System.out.print("Ingrese nuevo precio de venta: ");
                        productoActualizar.setprecio_venta(scanner.nextDouble());

                        System.out.print("Ingrese nueva categoría: ");
                        productoActualizar.setcategoria(scanner.next());

                        System.out.print("Ingrese nueva cantidad disponible: ");
                        productoActualizar.setcantidad_disponible(scanner.nextInt());

                        if (inventarioDAO.actualizarProducto(productoActualizar)) {
                            System.out.println("Producto actualizado exitosamente.");
                        } else {
                            System.out.println("Error al actualizar el producto.");
                        }
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    // Eliminar producto
                    System.out.print("Ingrese código del producto a eliminar: ");
                    int codEliminar = scanner.nextInt();
                    if (inventarioDAO.eliminarProducto(codEliminar)) {
                        System.out.println("Producto eliminado exitosamente.");
                    } else {
                        System.out.println("Error al eliminar el producto o producto no encontrado.");
                    }
                    break;

                case 5:
                    // Salir
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}

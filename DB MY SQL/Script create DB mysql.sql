-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS kd_electronics;

-- Usar la base de datos recién creada
USE kd_electronics;

-- Crear la tabla inventario
CREATE TABLE IF NOT EXISTS inventario (
    cod_producto INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio_base DECIMAL(10, 2) NOT NULL,
    precio_venta DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(50),
    cantidad_disponible INT NOT NULL
);
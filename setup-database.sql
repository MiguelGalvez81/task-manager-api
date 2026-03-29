-- ===================================================
-- Task Manager API - Database Setup Script
-- Database: MySQL
-- ===================================================

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS taskdb;
USE taskdb;

-- Tabla USER
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla TASK
CREATE TABLE IF NOT EXISTS `task` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT,
    `status` VARCHAR(50),
    `user_id` BIGINT,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_task_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Índices para mejorar performance
CREATE INDEX `idx_task_user_id` ON `task` (`user_id`);
CREATE INDEX `idx_task_status` ON `task` (`status`);
CREATE INDEX `idx_user_username` ON `user` (`username`);

-- ===================================================
-- Script de datos de prueba (opcional)
-- ===================================================

-- Insertar usuarios de prueba
INSERT INTO `user` (`username`, `password`) VALUES 
('admin', 'admin123'),
('user1', 'password1'),
('user2', 'password2');

-- Insertar tareas de prueba
INSERT INTO `task` (`title`, `description`, `status`, `user_id`) VALUES 
('Implementar API REST', 'Crear endpoints para gestión de tareas', 'IN_PROGRESS', 1),
('Configurar base de datos', 'Configurar conexión a MySQL', 'COMPLETED', 1),
('Escribir tests', 'Crear pruebas unitarias', 'PENDING', 2),
('Documentación', 'Documentar los endpoints de la API', 'PENDING', 3),
('Despliegue', 'Preparar para producción', 'IN_PROGRESS', 1);

-- ===================================================
-- Verificar datos creados
-- ===================================================
SELECT 'Usuarios creados:' AS info;
SELECT * FROM `user`;

SELECT 'Tareas creadas:' AS info;
SELECT * FROM `task`;

package com.mg.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Schema(description = "Modelo de Usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombre de usuario único", example = "john_doe", required = true)
    private String username;

    @Schema(description = "Contraseña del usuario", example = "password123", required = true)
    private String password;
}
package com.mg.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Schema(description = "Modelo de Tarea")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la tarea", example = "1")
    private Long id;

    @Schema(description = "Título de la tarea", example = "Completar proyecto", required = true)
    private String title;

    @Schema(description = "Descripción detallada de la tarea", example = "Terminar la implementación del backend")
    private String description;

    @Schema(description = "Estado de la tarea", example = "PENDIENTE", allowableValues = {"PENDIENTE", "EN_PROGRESO", "COMPLETADA"})
    private String status;

    @ManyToOne
    @Schema(description = "Usuario propietario de la tarea")
    private User user;
}
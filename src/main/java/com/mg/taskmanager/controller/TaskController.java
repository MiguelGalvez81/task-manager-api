package com.mg.taskmanager.controller;

import com.mg.taskmanager.model.Task;
import com.mg.taskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "API para gestionar tareas")
@SecurityRequirement(name = "bearerAuth")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Retorna una lista de todas las tareas creadas")
    @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class)))
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea", description = "Crea una nueva tarea en el sistema")
    @ApiResponse(responseCode = "200", description = "Tarea creada correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class)))
    @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    public Task create(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea específica por su ID")
    @ApiResponse(responseCode = "200", description = "Tarea eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    public void delete(@Parameter(description = "ID de la tarea a eliminar") @PathVariable Long id) {
        taskService.delete(id);
    }
}
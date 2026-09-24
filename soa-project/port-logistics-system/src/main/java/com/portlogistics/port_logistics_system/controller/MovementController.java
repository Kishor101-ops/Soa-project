package com.portlogistics.port_logistics_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.entity.Movement;
import com.portlogistics.port_logistics_system.service.MovementService;

@RestController
@RequestMapping("/api/movements")
public class MovementController {

    private final MovementService service;

    public MovementController(MovementService service) {
        this.service = service;
    }

    @PostMapping
    public Movement addMovement(@RequestBody Movement movement) {
        return service.addMovement(movement);
    }

    @GetMapping
    public List<Movement> getAllMovements() {
        return service.getAllMovements();
    }

    @GetMapping("/{id}")
    public Movement getMovementById(@PathVariable Long id) {
        return service.getMovementById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMovement(@PathVariable Long id) {
        service.deleteMovement(id);
        return "Movement deleted successfully";
    }
}
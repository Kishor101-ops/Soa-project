package com.portlogistics.port_logistics_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portlogistics.port_logistics_system.entity.Movement;
import com.portlogistics.port_logistics_system.repository.MovementRepository;

@Service
public class MovementService {

    private final MovementRepository repository;

    public MovementService(MovementRepository repository) {
        this.repository = repository;
    }

    public Movement addMovement(Movement movement) {
        return repository.save(movement);
    }

    public List<Movement> getAllMovements() {
        return repository.findAll();
    }

    public Movement getMovementById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteMovement(Long id) {
        repository.deleteById(id);
    }
}
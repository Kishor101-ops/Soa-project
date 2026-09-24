package com.portlogistics.port_logistics_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portlogistics.port_logistics_system.entity.Truck;
import com.portlogistics.port_logistics_system.repository.TruckRepository;

@Service
public class TruckService {

    private final TruckRepository repository;

    public TruckService(TruckRepository repository) {
        this.repository = repository;
    }

    public Truck addTruck(Truck truck) {
        return repository.save(truck);
    }

    public List<Truck> getAllTrucks() {
        return repository.findAll();
    }

    public Truck getTruckById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteTruck(Long id) {
        repository.deleteById(id);
    }
}
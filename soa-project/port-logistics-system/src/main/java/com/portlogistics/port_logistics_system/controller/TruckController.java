package com.portlogistics.port_logistics_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.entity.Truck;
import com.portlogistics.port_logistics_system.service.TruckService;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    private final TruckService service;

    public TruckController(TruckService service) {
        this.service = service;
    }

    @PostMapping
    public Truck addTruck(@RequestBody Truck truck) {
        return service.addTruck(truck);
    }

    @GetMapping
    public List<Truck> getAllTrucks() {
        return service.getAllTrucks();
    }

    @GetMapping("/{id}")
    public Truck getTruckById(@PathVariable Long id) {
        return service.getTruckById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTruck(@PathVariable Long id) {
        service.deleteTruck(id);
        return "Truck deleted successfully";
    }
}
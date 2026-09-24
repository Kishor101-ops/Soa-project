package com.portlogistics.port_logistics_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.entity.Container;
import com.portlogistics.port_logistics_system.service.ContainerService;

@RestController
@RequestMapping("/api/containers")
public class ContainerController {

    private final ContainerService service;

    public ContainerController(ContainerService service) {
        this.service = service;
    }

    @PostMapping
    public Container addContainer(@RequestBody Container container) {
        return service.addContainer(container);
    }

    @GetMapping
    public List<Container> getAllContainers() {
        return service.getAllContainers();
    }

    @GetMapping("/{id}")
    public Container getContainerById(@PathVariable Long id) {
        return service.getContainerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteContainer(@PathVariable Long id) {
        service.deleteContainer(id);
        return "Container deleted successfully";
    }
}
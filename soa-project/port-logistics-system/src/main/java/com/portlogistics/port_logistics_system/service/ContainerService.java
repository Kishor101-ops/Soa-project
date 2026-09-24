package com.portlogistics.port_logistics_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portlogistics.port_logistics_system.entity.Container;
import com.portlogistics.port_logistics_system.repository.ContainerRepository;

@Service
public class ContainerService {

    private final ContainerRepository repository;

    public ContainerService(ContainerRepository repository) {
        this.repository = repository;
    }

    public Container addContainer(Container container) {
        return repository.save(container);
    }

    public List<Container> getAllContainers() {
        return repository.findAll();
    }

    public Container getContainerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteContainer(Long id) {
        repository.deleteById(id);
    }
}
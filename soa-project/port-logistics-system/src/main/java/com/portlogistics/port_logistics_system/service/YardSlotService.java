package com.portlogistics.port_logistics_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portlogistics.port_logistics_system.entity.YardSlot;
import com.portlogistics.port_logistics_system.repository.YardSlotRepository;

@Service
public class YardSlotService {

    private final YardSlotRepository repository;

    public YardSlotService(YardSlotRepository repository) {
        this.repository = repository;
    }

    public YardSlot addYardSlot(YardSlot yardSlot) {
        return repository.save(yardSlot);
    }

    public List<YardSlot> getAllYardSlots() {
        return repository.findAll();
    }

    public YardSlot getYardSlotById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteYardSlot(Long id) {
        repository.deleteById(id);
    }
}
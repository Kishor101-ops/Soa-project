package com.portlogistics.port_logistics_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portlogistics.port_logistics_system.entity.YardSlot;
import com.portlogistics.port_logistics_system.service.YardSlotService;

@RestController
@RequestMapping("/api/yard-slots")
public class YardSlotController {

    private final YardSlotService service;

    public YardSlotController(YardSlotService service) {
        this.service = service;
    }

    @PostMapping
    public YardSlot addYardSlot(@RequestBody YardSlot yardSlot) {
        return service.addYardSlot(yardSlot);
    }

    @GetMapping
    public List<YardSlot> getAllYardSlots() {
        return service.getAllYardSlots();
    }

    @GetMapping("/{id}")
    public YardSlot getYardSlotById(@PathVariable Long id) {
        return service.getYardSlotById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteYardSlot(@PathVariable Long id) {
        service.deleteYardSlot(id);
        return "Yard slot deleted successfully";
    }
}
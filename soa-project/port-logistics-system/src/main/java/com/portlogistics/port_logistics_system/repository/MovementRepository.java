package com.portlogistics.port_logistics_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portlogistics.port_logistics_system.entity.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
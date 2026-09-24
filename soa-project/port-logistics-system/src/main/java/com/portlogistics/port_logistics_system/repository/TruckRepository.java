package com.portlogistics.port_logistics_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portlogistics.port_logistics_system.entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {

}
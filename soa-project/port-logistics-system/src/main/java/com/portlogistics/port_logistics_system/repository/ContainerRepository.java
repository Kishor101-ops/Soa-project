package com.portlogistics.port_logistics_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portlogistics.port_logistics_system.entity.Container;

public interface ContainerRepository extends JpaRepository<Container, Long> {

}
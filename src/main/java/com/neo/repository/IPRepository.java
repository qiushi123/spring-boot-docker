package com.neo.repository;

import com.neo.model.Pv2048;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRepository extends JpaRepository<Pv2048, Long> {
}
package com.example.dplanner.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
}

package com.example.dplanner.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
}

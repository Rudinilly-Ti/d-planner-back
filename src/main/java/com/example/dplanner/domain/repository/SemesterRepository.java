package com.example.dplanner.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

}

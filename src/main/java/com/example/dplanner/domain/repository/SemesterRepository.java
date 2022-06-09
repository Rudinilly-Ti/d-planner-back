package com.example.dplanner.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dplanner.domain.entityes.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
    public List<Semester> findByUserId(Long userId);
}

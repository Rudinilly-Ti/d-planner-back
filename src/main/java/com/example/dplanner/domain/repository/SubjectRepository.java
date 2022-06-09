package com.example.dplanner.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.Semester;
import com.example.dplanner.domain.entityes.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
  public List<Subject> findBySemester(Semester semester);

  public List<Subject> findBySemester_User_Id(Long id);

}

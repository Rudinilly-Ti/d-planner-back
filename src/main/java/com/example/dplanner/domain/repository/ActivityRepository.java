package com.example.dplanner.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dplanner.domain.entityes.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	public List<Activity> findBySubject_Semester_User_id(long id);
}

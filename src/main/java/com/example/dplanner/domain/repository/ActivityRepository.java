package com.example.dplanner.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dplanner.domain.entityes.Activity;
import com.example.dplanner.domain.entityes.Activity.ActivityType;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	public List<Activity> findBySubject_Semester_User_id(long id);
	public List<Activity> findByStatusAndSubject_Semester_User_id(String status,long id);
	public List<Activity> findByStatusAndTypeAndSubject_Semester_User_id(String status,ActivityType type, long id );
	public List<Activity> findBySubject_Id(Long id);
}

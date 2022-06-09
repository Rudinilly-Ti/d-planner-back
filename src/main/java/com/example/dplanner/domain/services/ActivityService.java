package com.example.dplanner.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dplanner.domain.entityes.Activity;
import com.example.dplanner.domain.entityes.Subject;
import com.example.dplanner.domain.repository.ActivityRepository;

@Service
public class ActivityService {
	@Autowired
	ActivityRepository repository;

	public Activity create(Activity activity) {
		return repository.save(activity);
	}

	public void delete(Long id) {
		Activity activityToDelete = repository.findById(id).orElse(null);
		repository.delete(activityToDelete);
	}

	public Activity update(Activity activity) {
		Activity activityToUpdate = repository.findById(activity.getId()).get();
		if (activityToUpdate != null) {
			return repository.save(activity);
		}
		return activityToUpdate;
	}

	public List<Activity> index() {
		return repository.findAll();
	}
	public List<Activity> findByUser(Long ID) {
		return repository.findByStatusAndSubject_Semester_User_id("ABERTO",ID);
	}
	public List<Activity> findAllByUser(Long ID) {
		return repository.findBySubject_Semester_User_id(ID);
	}
	public List<Activity> findByUserAndType(Long ID,int type) {
		return repository.findByStatusAndTypeAndSubject_Semester_User_id("ABERTO",type, ID);
	}
	public Activity show(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Activity closeActivity(Activity activity) {
		Activity activityToUpdate = repository.findById(activity.getId()).get();
		if (activityToUpdate != null) {
			activity.setStatus("ENTREGUE");
			return repository.save(activity);
		}
		return activityToUpdate;
	}
}

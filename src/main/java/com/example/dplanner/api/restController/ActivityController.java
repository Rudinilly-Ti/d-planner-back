package com.example.dplanner.api.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dplanner.domain.entityes.Activity;
import com.example.dplanner.domain.entityes.Activity.ActivityType;
import com.example.dplanner.domain.services.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	ActivityService service;

	@PostMapping
	public Activity create(@Valid @RequestBody Activity activity) {
		return service.create(activity);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>("Atividade excluida com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao excluir atividade: " + e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping
	public ResponseEntity<String> update(@Valid @RequestBody Activity activity) {
		Activity activityToUpdate = service.update(activity);
		try {
			if (activityToUpdate == null) {
				throw new Error("Atividade não encontrada");
			}
			return new ResponseEntity<>("Atividade atualizada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao atualizar atividade: " + e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping
	public List<Activity> index() {
		return service.index();
	}

	@GetMapping(value = "/show/{id}")
	public Activity show(@PathVariable(value = "id") Long id) {
		return service.show(id);
	}

	@GetMapping(value = "/listByUser/{id}")
	public List<Activity> listByUser(@PathVariable(value = "id") Long id) {
		return service.findByUser(id);

	}

	@GetMapping(value = "/listAllByUser/{id}")
	public List<Activity> findAllByUser(@PathVariable(value = "id") Long id) {
		return service.findAllByUser(id);
	}

	@GetMapping(value = "/listBySubject/{id}")
	public List<Activity> listBySubject(@PathVariable(value = "id") Long id) {
		return service.findBySubject(id);

	}

	@GetMapping(value = "/listByUserType/{id}/{type}")
	public List<Activity> findByType(@PathVariable(value = "id") Long id,
			@PathVariable(value = "type") ActivityType type) {
		return service.findByUserAndType(id, type);

	}

	@PutMapping(value = "/close")
	public ResponseEntity<String> CloseActivity(@Valid @RequestBody Activity activity) {
		Activity activityToUpdate = service.closeActivity(activity);
		try {
			if (activityToUpdate == null) {
				throw new Error("Atividade não encontrada");
			}
			return new ResponseEntity<>("Atividade atualizada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao atualizar atividade: " + e.getMessage(), HttpStatus.OK);
		}
	}
}

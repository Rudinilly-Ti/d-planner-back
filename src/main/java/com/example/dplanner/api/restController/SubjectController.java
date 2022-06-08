package com.example.dplanner.api.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dplanner.domain.entityes.Subject;
import com.example.dplanner.domain.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
  @Autowired
  SubjectService service;

  public ResponseEntity<List<Subject>> findBySemesterId(@RequestParam Long semesterId) {
    return ResponseEntity.of(service.findBySemesterId(semesterId));
  }

  @PostMapping
  public Subject create(@RequestBody Subject subject) {
    return service.create(subject);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Subject> findById(@PathVariable Long id) {
    return ResponseEntity.of(service.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Subject> update(@PathVariable Long id, @RequestBody Subject subject) {
    return ResponseEntity.of(service.update(id, subject));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Subject> delete(@PathVariable Long id) {
    return ResponseEntity.of(service.delete(id));
  }
}

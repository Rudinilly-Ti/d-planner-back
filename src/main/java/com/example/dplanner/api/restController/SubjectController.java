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

import com.example.dplanner.api.dto.SubjectDto;
import com.example.dplanner.domain.entityes.Subject;
import com.example.dplanner.domain.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
  @Autowired
  SubjectService service;

  @GetMapping
  public ResponseEntity<List<Subject>> findBySemesterId(@RequestParam Long semesterId) {
    var semester = service.findBySemesterId(semesterId);
    if (semester.isPresent())
      return ResponseEntity.ok(semester.get());
    else
      return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Subject> create(@RequestBody SubjectDto dto) {
    var semester = service.create(dto);
    if (semester.isPresent())
      return ResponseEntity.ok(semester.get());
    else
      return ResponseEntity.badRequest().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Subject> findById(@PathVariable Long id) {
    var semester = service.findById(id);
    if (semester.isPresent())
      return ResponseEntity.ok(semester.get());
    else
      return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Subject> update(@PathVariable Long id, @RequestBody SubjectDto dto) {
    var semester = service.update(id, dto);
    if (semester.isPresent())
      return ResponseEntity.ok(semester.get());
    else
      return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Subject> delete(@PathVariable Long id) {
    var semester = service.delete(id);
    if (semester.isPresent())
      return ResponseEntity.ok(semester.get());
    else
      return ResponseEntity.badRequest().build();
  }
}

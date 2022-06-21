package com.example.dplanner.api.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dplanner.domain.entityes.Semester;
import com.example.dplanner.domain.repository.UserRepository;
import com.example.dplanner.domain.services.SemesterService;

@RestController
@RequestMapping("/semesters")
public class SemesterController {
    @Autowired
    SemesterService service;

    @Autowired
    UserRepository userRepo;

    @PostMapping("/{userId}")
    public ResponseEntity<Semester> create(@PathVariable Long userId, @RequestBody Semester semester) {
        semester.setUser(userRepo.findById(userId).get());
        Semester semesterTMP = service.create(semester);

        if (semesterTMP != null)
            return ResponseEntity.ok(semesterTMP);
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public Semester findByNome(@PathVariable String nome) {
        return service.findByNome(nome);
    }

    @GetMapping("/{userId}")
    public List<Semester> findSemester(@PathVariable Long userId) {
        return service.search(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semester> update(@PathVariable Long id, @RequestBody Semester semester) {
        semester.setId(id);

        Semester novoSemestre = service.update(semester);

        if (novoSemestre != null)
            return ResponseEntity.ok(semester);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Semester> delete(@PathVariable Long id) {

        Semester semester = service.delete(id);

        if (semester != null)
            return ResponseEntity.ok(semester);
        else
            return ResponseEntity.badRequest().build();
    }
}

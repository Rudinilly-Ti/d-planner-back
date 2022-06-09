package com.example.dplanner.api.restController;

import com.example.dplanner.domain.entityes.Semester;
import com.example.dplanner.domain.services.SemesterService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semesters")
public class SemesterController {
    @Autowired
    SemesterService service;

    @PostMapping
    public ResponseEntity<Semester> create(@Valid @RequestBody Semester semester) {
        
        Semester semesterTMP = service.create(semester);

        if (semesterTMP != null)
            return ResponseEntity.ok(semesterTMP);
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public List<Semester> list(){
        return service.list();
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

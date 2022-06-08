package com.example.dplanner.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dplanner.api.dto.SubjectDto;
import com.example.dplanner.domain.entityes.Semester;
import com.example.dplanner.domain.entityes.Subject;
import com.example.dplanner.domain.repository.SemesterRepository;
import com.example.dplanner.domain.repository.SubjectRepository;

@Service
public class SubjectService {
  @Autowired
  SubjectRepository repository;

  @Autowired
  SemesterRepository semesterRepo;

  public Optional<Subject> create(SubjectDto dto) {
    var optSemester = semesterRepo.findById(dto.getSemesterId());

    if (optSemester.isEmpty())
      return Optional.empty();

    var subject = new Subject();
    subject.setNome(dto.getNome());
    subject.setProfessor(dto.getProfessor());
    subject.setSemester(optSemester.get());

    return Optional.of(repository.save(subject));
  }

  public Optional<List<Subject>> findBySemesterId(Long semesterId) {
    Optional<Semester> semester = semesterRepo.findById(semesterId);

    if (semester.isEmpty())
      return Optional.empty();

    List<Subject> subjects = repository.findBySemester(semester.get());

    return Optional.of(subjects);
  }

  public Optional<Subject> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<Subject> update(Long id, SubjectDto dto) {
    var optSubject = repository.findById(id);
    var optSemester = semesterRepo.findById(dto.getSemesterId());

    if (optSubject.isEmpty() || optSemester.isEmpty())
      return Optional.empty();

    var subject = optSubject.get();

    subject.setNome(dto.getNome());
    subject.setProfessor(dto.getProfessor());
    subject.setSemester(optSemester.get());

    return Optional.of(repository.save(subject));
  }

  public Optional<Subject> delete(Long id) {
    var subject = repository.findById(id);
    if (subject.isPresent())
      repository.delete(subject.get());

    return subject;
  }

}

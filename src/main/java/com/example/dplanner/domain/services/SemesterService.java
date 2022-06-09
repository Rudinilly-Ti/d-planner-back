package com.example.dplanner.domain.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dplanner.domain.entityes.Semester;
import com.example.dplanner.domain.repository.SemesterRepository;

@Service
public class SemesterService {
    @Autowired
    SemesterRepository repository;

    //Create
    public Semester create(Semester semester) {
        return repository.save(semester);
    }
    
    //Read
    public List<Semester> search(Long userId){
        return repository.findByUserId(userId);
    }
    public List<Semester> list(){
        return repository.findAll();
    }

    //Update
    public Semester update(Semester semester) {
        Optional<Semester> tmp = repository.findById(semester.getId());

        if (tmp.isEmpty()){
            return null;
        }

        Semester retorno = tmp.get();

        retorno.setNome(semester.getNome());
        retorno.setDataDeInicio(semester.getDataDeInicio());
        retorno.setDataDeFim(semester.getDataDeFim());

        return repository.save(retorno);
    }

    //Delete  
    public Semester delete(Long id) {
        Optional<Semester> semester = repository.findById(id);
        
        if (!semester.isEmpty()){   
            repository.delete(semester.get());
        }
        return semester.get();
    }
}

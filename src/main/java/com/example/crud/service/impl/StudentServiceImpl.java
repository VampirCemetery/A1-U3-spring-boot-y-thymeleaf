package com.example.crud.service.impl;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;
import com.example.crud.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;
    public StudentServiceImpl(StudentRepository repo) { this.repo = repo; }

    @Override public List<Student> findAll() { return repo.findAll(); }
    @Override public Optional<Student> findById(Long id) { return repo.findById(id); }
    @Override public Student save(Student s) { return repo.save(s); }
    @Override public void deleteById(Long id) { repo.deleteById(id); }
}

package com.example.demo.service;

import com.example.demo.repository.entity.Student;
import com.example.demo.repository.entity.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudentInfo(Student student) {
        studentRepository.save(student);
    }
}

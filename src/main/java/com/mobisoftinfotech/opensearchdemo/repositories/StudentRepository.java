package com.mobisoftinfotech.opensearchdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobisoftinfotech.opensearchdemo.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
} 
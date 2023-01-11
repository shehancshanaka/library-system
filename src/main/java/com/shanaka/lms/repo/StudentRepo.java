package com.shanaka.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shanaka.lms.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}

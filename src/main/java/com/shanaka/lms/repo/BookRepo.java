package com.shanaka.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shanaka.lms.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}

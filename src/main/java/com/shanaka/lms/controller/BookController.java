package com.shanaka.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shanaka.lms.entity.Book;
import com.shanaka.lms.entity.Student;
import com.shanaka.lms.repo.BookRepo;
import com.shanaka.lms.repo.StudentRepo;

@Controller
public class BookController {

    @Autowired
    private BookRepo repo;
    @Autowired
    private StudentRepo stuRepo;

    @GetMapping("/bookHomePage")
    public String homePage(Model model) {
        model.addAttribute("booklist", repo.findAll());
        return "book_home";
    }

    @GetMapping("saveBookPage")
    public String saveBookPage(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        repo.save(book);
        return "redirect:/";
    }

    @GetMapping("/updateBookPage/{id}")
    public String showUpdateBookPage(@PathVariable("id") int id, Model model) {
        Optional<Book> temp = repo.findById(id);
        Book book = temp.get();
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/lendBook/{id}/{userid}")
    public String lendBook(@PathVariable("id") int id, @PathVariable("userid") int userid) {
        Optional<Book> temp = repo.findById(id);
        Book book = temp.get();
        Optional<Student> temp1 = stuRepo.findById(userid);
        Student student = temp1.get();

        List<Student> studentlist = book.getStudentlist();
        if (studentlist == null) {
            studentlist = new ArrayList<>();

        }
        studentlist.add(student);
        book.setStudentlist(studentlist);
        repo.save(book);
        return "redirect:/";
    }

}
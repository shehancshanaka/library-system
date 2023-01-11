package com.shanaka.lms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String email;
    private String mobile;
    @ManyToMany(mappedBy = "studentlist")
    private List<Book> booktlist;

    public Student(String name, String address, String email, String mobile) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

}

package com.mimi.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
//Each course (represented by an instance of the Course entity) is associated with exactly one instructor
// (represented by an instance of the Instructor entity).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "title")
    private String title ;
//Multiple instances of the Course entity can be linked to
// a single instance of the Instructor entity.
    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,
                        CascadeType.DETACH , CascadeType.REFRESH} )
    @JoinColumn(name = "instructor_id")
    private Instructor instructor ;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

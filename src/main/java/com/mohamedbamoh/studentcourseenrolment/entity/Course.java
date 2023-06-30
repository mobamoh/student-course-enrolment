package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "Course")
@Table(name = "course")
public class Course {

    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_seq")
    @Column(name = "id",
            updatable = false)
    @Id
    private Long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "department",
            nullable = false,
            columnDefinition = "TEXT")
    private String department;

//    @ManyToMany(mappedBy = "courses")
//    private List<Student> students;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    private List<Enrolment> enrolments;
}

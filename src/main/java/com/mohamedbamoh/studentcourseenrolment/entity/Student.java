package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "student_email_uk", columnNames = "email")
})
public class Student {


    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    @Column(name = "id", updatable = false)
    @Id
    private Long Id;

    @Column(name = "first_name",
            nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name",
            nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email",
            nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private StudentCard studentCard;

    @OneToMany(mappedBy = "student",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Book> books;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "enrolment",
//            joinColumns = @JoinColumn(name = "student_id",
//                    foreignKey = @ForeignKey(name = "student_id_fk")
//            ),
//            inverseJoinColumns = @JoinColumn(name = "course_id",
//                    foreignKey = @ForeignKey(name = "course_id_fk")
//            )
//    )
//    private List<Course> courses;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "student"
    )
    private List<Enrolment> enrolments;

    public void addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
            book.setStudent(null);
        }
    }

}

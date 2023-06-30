package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "book_seq")
    @Column(name = "id", updatable = false)
    @Id
    private Long Id;

    @Column(name = "book_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String bookName;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;
}

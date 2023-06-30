package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id",
            foreignKey = @ForeignKey(name = "course_id_fk")
     )
    private Course course;

    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;
}

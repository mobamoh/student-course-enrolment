package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EnrolmentId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id ")
    private Long courseId;
}

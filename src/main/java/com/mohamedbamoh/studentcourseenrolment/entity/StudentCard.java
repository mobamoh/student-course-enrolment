package com.mohamedbamoh.studentcourseenrolment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "StudentCard")
@Table(name = "student_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_card_number_uk",
                        columnNames = "card_number")
        }
)
public class StudentCard {

    @SequenceGenerator(name = "student_card_seq",
            sequenceName = "student_card_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_card_seq")
    @Column(name = "id", updatable = false)
    @Id
    private Long id;

    @Column(name = "card_number",
            nullable = false,
            columnDefinition = "TEXT")
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;
}

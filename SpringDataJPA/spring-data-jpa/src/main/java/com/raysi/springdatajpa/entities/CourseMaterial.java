package com.raysi.springdatajpa.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courseMaterial")
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false // It will force you to add course in the CourseMaterial other wise it will throw error
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Courses course;
}

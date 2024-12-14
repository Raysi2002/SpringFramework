package com.raysi.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany( // JPA always suggests you to create @ManyToOne relationship instead of @OneToMany
//            cascade = CascadeType.ALL
//
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Courses> courses;
}

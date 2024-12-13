package com.raysi.booksmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = {"book_name", "author"})
    }
)
@Builder
@ToString
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    @Column(
            nullable = false,
            unique = true
    )
    private String bookName;
    private String genre;
    @Embedded
    @Column(unique = true)
    private Author author;
}

package com.raysi.booksmanagement.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Author {
    private String authorName;
    private String email;
    private String phone;
}

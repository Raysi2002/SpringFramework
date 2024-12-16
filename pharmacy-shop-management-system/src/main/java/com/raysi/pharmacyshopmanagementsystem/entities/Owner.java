package com.raysi.pharmacyshopmanagementsystem.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "medicine")
public class Owner {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    private String degree;
}

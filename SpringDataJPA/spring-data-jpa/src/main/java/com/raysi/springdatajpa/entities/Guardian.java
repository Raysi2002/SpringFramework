package com.raysi.springdatajpa.entities;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guardian {
    private String guardianName;
    private String guardianEmail;
    private String guardianPhone;
}

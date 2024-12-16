package com.raysi.pharmacyshopmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id
    private Long id;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "medicine")
    private Medicine medicine;
    private Long quantity;
}

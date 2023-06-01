package dev.beagracia.handsonwork_imobiliaria.ImobiliariaAPI.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String description;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    private String area;

    private Long price;

    private int numberOfBedrooms;

    private int numberOfCarSpots;

    private int numberOfBathrooms;

}

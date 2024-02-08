package com.example.zoomcar.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnhancementType {

    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Enhancements enhancement;
    private String description;
    private double price;

}

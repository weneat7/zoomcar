package com.example.zoomcar.models;

import java.sql.Date;
import lombok.Getters;
import lombok.Setters;

@Getters
@Setters

public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}

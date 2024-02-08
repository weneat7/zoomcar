package com.example.zoomcar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment extends BaseModel{
    @Enumerated(jakarta.persistence.EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    private double amount;
    private String referenceId;
    private String paymentStatus;
}

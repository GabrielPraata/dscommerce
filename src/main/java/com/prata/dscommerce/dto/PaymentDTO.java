package com.prata.dscommerce.dto;

import com.prata.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentDTO {
    private Long id;
    private Instant moment;

    public PaymentDTO () {
    }

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}

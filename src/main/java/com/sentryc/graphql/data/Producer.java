package com.sentryc.graphql.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "producers")
@Data
public class Producer {

    @Id
    private UUID id;

    private String name;

    @Column(name = "created_at")
    private Instant createdAt;
}

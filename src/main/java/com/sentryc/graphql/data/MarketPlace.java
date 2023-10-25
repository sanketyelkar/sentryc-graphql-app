package com.sentryc.graphql.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marketplaces")
@Data
public class MarketPlace {

    @Id
    private String id;

    private String description;
}

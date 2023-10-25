package com.sentryc.graphql.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "seller_infos")
@Data
public class SellerInformation {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    private MarketPlace marketPlace;

    private String name;
    private String url;
    private String country;

    @Column(name = "external_id")
    private String externalId;
}

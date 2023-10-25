package com.sentryc.graphql.data;

import com.sentryc.graphql.dto.enums.seller.State;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "sellers")
@Data
public class Seller {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seller_info_id", referencedColumnName = "id")
    private SellerInformation sellerInformation;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @Enumerated(EnumType.STRING)
    private State state;

}

package com.sentryc.graphql.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class SellerAndMarketPlaceDTO {
    String name;
    String externalId;
    String marketPlaceId;

    public SellerAndMarketPlaceDTO(String externalId, String marketPlaceId, String name) {
        this.name = name;
        this.externalId = externalId;
        this.marketPlaceId = marketPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerAndMarketPlaceDTO that = (SellerAndMarketPlaceDTO) o;
        return Objects.equals(externalId, that.externalId) &&
                Objects.equals(marketPlaceId, that.marketPlaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, marketPlaceId);
    }
}
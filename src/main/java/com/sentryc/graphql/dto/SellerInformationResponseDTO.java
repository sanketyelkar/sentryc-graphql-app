package com.sentryc.graphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SellerInformationResponseDTO {

    private String sellerName;

    private String externalId;

    private String marketplaceId;

    private List<ProducerSellerStateDTO> producerSellerStateDTOS;
}

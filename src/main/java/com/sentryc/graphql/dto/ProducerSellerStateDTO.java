package com.sentryc.graphql.dto;

import com.sentryc.graphql.dto.enums.seller.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProducerSellerStateDTO {
    private String producerId;
    private String producerName;
    private State state;
    private String sellerId;
}

package com.sentryc.graphql.utils;

import com.sentryc.graphql.dto.SellerInformationResponseDTO;
import com.sentryc.graphql.utils.Page;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SellerPageableResponse {

    private Page meta;

    private List<SellerInformationResponseDTO> data;
}

package com.sentryc.graphql.controller;

import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.utils.SellerPageableResponse;
import com.sentryc.graphql.dto.enums.seller.Sorting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class SellerInfoControllerIntegrationTest {

    @Autowired
    private SellerController sellerController;

    @Test
    public void TestGetSellerInfosByFilter() {
        Filter filter = new Filter();
        filter.setSearchByName("Amazon US");
        filter.setProducerIds(List.of(UUID.fromString("64eb76cb-2b62-4891-b59e-50694a48f376")));
        filter.setMarketplaceIds(List.of("amazon.ae"));

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(0);
        pageRequest.setSize(10);

        SellerPageableResponse sellerPageableResponse = sellerController.getSellerInformationByFilter(filter, pageRequest, Sorting.SELLER_INFO_EXTERNAL_ID_ASC);
        assertEquals(sellerPageableResponse.getData().get(0).getExternalId(), "A2QUTRSO1ZHRN9");
    }
}

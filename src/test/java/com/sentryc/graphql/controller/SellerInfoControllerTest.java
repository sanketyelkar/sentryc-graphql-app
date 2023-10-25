package com.sentryc.graphql.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.graphql.utils.Page;
import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.utils.SellerPageableResponse;
import com.sentryc.graphql.dto.enums.seller.Sorting;
import com.sentryc.graphql.service.SellerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerController.class})
@ExtendWith(SpringExtension.class)
class SellerInfoControllerTest {
    @Autowired
    private SellerController sellerController;

    @MockBean
    private SellerService sellerService;

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.SELLER_INFO_EXTERNAL_ID_ASC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter2() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.SELLER_INFO_EXTERNAL_ID_DESC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter3() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.NAME_ASC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter4() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.NAME_DESC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter5() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.MARKETPLACE_ID_ASC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }

    /**
     * Method under test: {@link SellerController#getSellerInformationByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter6() {
        SellerPageableResponse sellerPageableResponse = new SellerPageableResponse();
        sellerPageableResponse.setData(new ArrayList<>());
        sellerPageableResponse.setMeta(new Page(1, 3, 1));
        when(sellerService.getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any())).thenReturn(sellerPageableResponse);

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageRequest page = new PageRequest();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponse,
                sellerController.getSellerInformationByFilter(filter, page, Sorting.MARKETPLACE_ID_DESC));
        verify(sellerService).getSellerInfosByFilter(Mockito.<Filter>any(), Mockito.<PageRequest>any(),
                Mockito.<Sorting>any());
    }
}


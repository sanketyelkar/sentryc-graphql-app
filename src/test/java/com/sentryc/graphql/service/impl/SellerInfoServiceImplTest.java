package com.sentryc.graphql.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.graphql.utils.Page;
import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.utils.SellerPageableResponse;
import com.sentryc.graphql.dto.enums.seller.Sorting;
import com.sentryc.graphql.repo.SellerRepo;
import com.sentryc.graphql.data.Seller;
import com.sentryc.graphql.repo.SellerInfoRepo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SellerInfoServiceImplTest {
    @MockBean
    private SellerInfoRepo sellerInfoRepo;

    @Autowired
    private SellerServiceImpl sellerInfoServiceImpl;

    @MockBean
    private SellerRepo sellerRepo;

    /**
     * Method under test: {@link SellerServiceImpl#getSellerInfosByFilter(Filter, PageRequest, Sorting)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        when(sellerRepo.findAll(Mockito.<Specification<Seller>>any())).thenReturn(new ArrayList<>());

        Filter filter = new Filter();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageRequest page = mock(PageRequest.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponse actualSellerInfosByFilter = sellerInfoServiceImpl.getSellerInfosByFilter(filter, page,
                Sorting.SELLER_INFO_EXTERNAL_ID_ASC);
        assertTrue(actualSellerInfosByFilter.getData().isEmpty());
        Page meta = actualSellerInfosByFilter.getMeta();
        assertEquals(0, meta.getPage());
        assertEquals(0, meta.getTotalRecords());
        assertEquals(3, meta.getSize());
        verify(sellerRepo).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }
}


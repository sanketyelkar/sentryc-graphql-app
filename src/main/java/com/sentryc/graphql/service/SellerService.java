package com.sentryc.graphql.service;

import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.utils.SellerPageableResponse;
import com.sentryc.graphql.dto.enums.seller.Sorting;

public interface SellerService {
    SellerPageableResponse getSellerInfosByFilter(Filter filter, PageRequest page, Sorting sortBy);
}

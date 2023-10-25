package com.sentryc.graphql.controller;

import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.dto.enums.seller.Sorting;
import com.sentryc.graphql.utils.SellerPageableResponse;
import com.sentryc.graphql.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SellerController {


    private final SellerService sellerService;

    @QueryMapping("sellers")
    public SellerPageableResponse getSellerInformationByFilter(@Argument Filter filter, @Argument PageRequest page, @Argument Sorting sortBy) {
        return sellerService.getSellerInfosByFilter(filter, page, sortBy);
    }
}

package com.sentryc.graphql.service.impl;

import com.sentryc.graphql.dto.*;
import com.sentryc.graphql.dto.enums.seller.Sorting;
import com.sentryc.graphql.repo.SellerRepo;
import com.sentryc.graphql.service.SellerService;
import com.sentryc.graphql.data.Seller;
import com.sentryc.graphql.repo.SellerInfoRepo;
import com.sentryc.graphql.utils.Filter;
import com.sentryc.graphql.utils.Page;
import com.sentryc.graphql.utils.PageRequest;
import com.sentryc.graphql.utils.SellerPageableResponse;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepo sellerInfoRepo;

    @Autowired
    private SellerRepo sellerRepo;

    @Override
    public SellerPageableResponse getSellerInfosByFilter(Filter filter, PageRequest page, Sorting sortBy) {
        Specification<Seller> specification = getSellerSpecification(filter);
        List<Seller> sellerList = sellerRepo.findAll(specification);
        List<SellerInformationResponseDTO> sellerInformationResponseDTOList = new ArrayList<>();
        Map<SellerAndMarketPlaceDTO, List<Seller>> sellerInfoListMap = sellerList.stream().collect(Collectors.groupingBy(sellerInfo -> new SellerAndMarketPlaceDTO(sellerInfo.getSellerInformation().getExternalId(), sellerInfo.getSellerInformation().getMarketPlace().getId(), sellerInfo.getSellerInformation().getName())));
        sellerInfoListMap.forEach((sellerAndMarketPlaceDTO, sellersList) -> createSellerInfoResponseDTO(sellerAndMarketPlaceDTO, sellersList, sellerInformationResponseDTOList));

        sortSellerResponse(sortBy, sellerInformationResponseDTOList);
        PageImpl<SellerInformationResponseDTO> pageable = getSellerResponsePage(page, sellerInformationResponseDTOList);
        return getSellerPageableResponseDTO(page, pageable, sellerInformationResponseDTOList);
    }

    private SellerPageableResponse getSellerPageableResponseDTO(PageRequest page, PageImpl<SellerInformationResponseDTO> pageable, List<SellerInformationResponseDTO> sellerInformationResponseDTOList) {
        return SellerPageableResponse.builder()
                .data(pageable.getContent())
                .meta(new Page(page.getPage(), page.getSize(), sellerInformationResponseDTOList.size())).build();
    }

    private PageImpl<SellerInformationResponseDTO> getSellerResponsePage(PageRequest page, List<SellerInformationResponseDTO> sellerInformationResponseDTOList) {
        int start = page.getPage() * page.getSize();
        int end = Math.min(start + page.getSize(), sellerInformationResponseDTOList.size());
        List<SellerInformationResponseDTO> sellerInformationResponseDTOListPageable = sellerInformationResponseDTOList.subList(start, end);
        return new PageImpl<>(sellerInformationResponseDTOListPageable, org.springframework.data.domain.PageRequest.of(page.getPage(), page.getSize()), sellerInformationResponseDTOList.size());
    }

    private void sortSellerResponse(Sorting sortBy, List<SellerInformationResponseDTO> sellerInformationResponseDTOList) {
        switch (sortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getExternalId));
            case SELLER_INFO_EXTERNAL_ID_DESC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getExternalId).reversed());
            case NAME_ASC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getSellerName));
            case NAME_DESC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getSellerName).reversed());
            case MARKETPLACE_ID_ASC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getMarketplaceId));
            case MARKETPLACE_ID_DESC ->
                    sellerInformationResponseDTOList.sort(Comparator.comparing(SellerInformationResponseDTO::getMarketplaceId).reversed());
        }
    }

    private void createSellerInfoResponseDTO(SellerAndMarketPlaceDTO sellerAndMarketPlaceDTO, List<Seller> sellersList, List<SellerInformationResponseDTO> sellerInformationResponseDTOList) {
        List<ProducerSellerStateDTO> producerSellerStateDTOList = new ArrayList<>();
        sellersList.forEach(seller -> createProducerSellerStateDTO(seller, producerSellerStateDTOList));

        SellerInformationResponseDTO.builder()
                .sellerName(sellerAndMarketPlaceDTO.getName())
                .externalId(sellerAndMarketPlaceDTO.getExternalId())
                .marketplaceId(sellerAndMarketPlaceDTO.getMarketPlaceId())
                .producerSellerStateDTOS(producerSellerStateDTOList);
    }

    private void createProducerSellerStateDTO(Seller seller, List<ProducerSellerStateDTO> producerSellerStateDTOList) {
        producerSellerStateDTOList.add(ProducerSellerStateDTO.builder()
                .sellerId(seller.getSellerInformation().getId().toString())
                .state(seller.getState())
                .producerName(seller.getProducer().getName())
                .producerId(seller.getProducer().getId().toString()).build());

    }

    private Specification<Seller> getSellerSpecification(Filter filter) {
        Specification<Seller> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(filter.getSearchByName())) {
                predicates.add(criteriaBuilder.like(root.get("sellerInfo").get("name"), "%" + filter.getSearchByName() + "%"));
            }
            if (filter.getProducerIds() != null && !filter.getProducerIds().isEmpty()) {
                predicates.add(root.get("producer").get("id").in(filter.getProducerIds()));
            }
            if (filter.getMarketplaceIds() != null && !filter.getMarketplaceIds().isEmpty()) {
                predicates.add(root.get("sellerInfo").get("marketPlace").get("id").in(filter.getMarketplaceIds()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return specification;
    }
}

package com.sentryc.graphql.utils;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Filter {

    private String searchByName;

    private List<UUID> producerIds;

    private List<String> marketplaceIds;
}

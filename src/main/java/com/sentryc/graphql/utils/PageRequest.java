package com.sentryc.graphql.utils;

import lombok.Data;

@Data
public class PageRequest {
    private int page;
    private int size;
}

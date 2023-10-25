package com.sentryc.graphql.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Page {

    private int page;

    private int size;

    private int totalRecords;
}

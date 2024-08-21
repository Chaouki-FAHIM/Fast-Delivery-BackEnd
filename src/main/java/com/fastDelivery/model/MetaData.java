package com.fastDelivery.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MetaData {
    private int totalCount;
    private int page;
    private int perPage;
}

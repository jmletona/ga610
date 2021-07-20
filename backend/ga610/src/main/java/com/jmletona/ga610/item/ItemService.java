package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ItemService implements IItem {
    private Integer serviceId;
    private String serviceName;
    private String urlImage;
    private String createdAt;
}

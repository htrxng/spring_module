package com.codegym.dto;

import java.time.LocalDate;

public interface OccupiedCustomerDto {
    String getOccCustomerId();
    String getOccCustomerCode();
    String getOccCustomerName();
    String getOccCustomerTypeName();
    String getOccStartDate();
    String getOccEndDate();
    String getAttachServiceName();
    String getAttachServiceStatus();
    String getQuantity();
}

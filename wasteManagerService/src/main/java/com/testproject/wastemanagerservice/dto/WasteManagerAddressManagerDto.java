package com.testproject.wastemanagerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteManagerAddressManagerDto {

    private String direccion;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
}

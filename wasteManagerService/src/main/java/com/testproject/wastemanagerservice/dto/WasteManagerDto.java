package com.testproject.wastemanagerservice.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WasteManagerDto {

    private String nombre;
    private String nif;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
    private WasteManagerAddressManagerDto wasteManagerAddressManagerDto;
    private List<WasteCenterAuthorizationDto> listOfWasteCenterAuthorizationDto;

}

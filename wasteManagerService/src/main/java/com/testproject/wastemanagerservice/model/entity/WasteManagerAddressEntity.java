package com.testproject.wastemanagerservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "wasteManagerAddress")
@Getter
@Setter
@NoArgsConstructor
public class WasteManagerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "IS_ENABLED")
    private int isEnabled;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "MANAGER_ID")
    private long manager_Id;
}

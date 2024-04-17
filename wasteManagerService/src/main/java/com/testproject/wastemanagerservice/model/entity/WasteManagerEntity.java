package com.testproject.wastemanagerservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "wasteManager")
@Getter
@Setter
@NoArgsConstructor
public class WasteManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "IS_ENABLED")
    private int isEnabled;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @OneToOne(cascade = CascadeType.ALL)
    private WasteManagerAddressEntity wasteManagerAddressEntity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MANAGER_ID", nullable = false, insertable = false, updatable = false)
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorizationEntity;
}

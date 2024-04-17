package com.testproject.wastemanagerservice.model.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wasteCenterAuthorization")
@Getter
@Setter
@NoArgsConstructor
public class WasteCenterAuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "AUTHORIZATION_NUMBER")
    private String authorizationNumber;

    @Column(name = "MANAGER_ID")
    private long manager_Id;
}

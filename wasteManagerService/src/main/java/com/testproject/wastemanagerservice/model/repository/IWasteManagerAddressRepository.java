package com.testproject.wastemanagerservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testproject.wastemanagerservice.model.entity.WasteManagerAddressEntity;

@Repository
public interface IWasteManagerAddressRepository extends JpaRepository<WasteManagerAddressEntity,Long> {
}

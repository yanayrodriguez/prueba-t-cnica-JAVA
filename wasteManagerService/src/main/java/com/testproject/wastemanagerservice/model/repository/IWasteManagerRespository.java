package com.testproject.wastemanagerservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testproject.wastemanagerservice.model.entity.WasteManagerEntity;

@Repository
public interface IWasteManagerRespository extends JpaRepository<WasteManagerEntity,Long> {
}

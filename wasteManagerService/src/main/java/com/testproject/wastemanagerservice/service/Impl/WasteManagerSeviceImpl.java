package com.testproject.wastemanagerservice.service.Impl;

import javassist.NotFoundException;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testproject.wastemanagerservice.dto.WasteManagerDto;
import com.testproject.wastemanagerservice.mapper.IWasteMapper;
import com.testproject.wastemanagerservice.model.entity.WasteManagerEntity;
import com.testproject.wastemanagerservice.model.repository.IWasteManagerRespository;
import com.testproject.wastemanagerservice.service.IWasteManagerSevice;

@Service
public class WasteManagerSeviceImpl implements IWasteManagerSevice {
    @Autowired
    IWasteManagerRespository wasteManagerRespository;

    @Override
    public WasteManagerDto create(WasteManagerDto wasteManagerDto) throws Exception {

        WasteManagerEntity newWasteManagerEntity = IWasteMapper.INSTANCE.toEntity(wasteManagerDto);

        newWasteManagerEntity.setCreatedDate(new java.sql.Date(new Date().getTime()));
        newWasteManagerEntity.setLastModifiedDate(new java.sql.Date(new Date().getTime()));

        return IWasteMapper.INSTANCE
                .toDto(wasteManagerRespository.save(newWasteManagerEntity));
    }

    @Override
    public WasteManagerDto update(WasteManagerDto wasteManagerDto, Long id) throws Exception {
        WasteManagerEntity oldWasteManagerEntity = wasteManagerRespository.findById(id)
                .orElseThrow(() -> new NotFoundException("No data found for the id: " + id));

        WasteManagerEntity wasteManagerEntity = IWasteMapper.INSTANCE.toEntity(wasteManagerDto);

        wasteManagerEntity.setId(oldWasteManagerEntity.getId());
        wasteManagerEntity.setLastModifiedDate(new java.sql.Date(new Date().getTime()));

        return IWasteMapper.INSTANCE.toDto(wasteManagerRespository.save(wasteManagerEntity));
    }

    @Override
    public WasteManagerDto findById(long wasteManagerId) throws NotFoundException {
        WasteManagerEntity wasteManagerEntity = wasteManagerRespository.findById(wasteManagerId)
                .orElseThrow(() -> new NotFoundException("No data found for the id: " + wasteManagerId));

        return IWasteMapper.INSTANCE.toDto(wasteManagerEntity);
    }
}

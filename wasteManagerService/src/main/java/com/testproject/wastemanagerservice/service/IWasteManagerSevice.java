package com.testproject.wastemanagerservice.service;

import com.testproject.wastemanagerservice.dto.WasteManagerDto;

import javassist.NotFoundException;


public interface IWasteManagerSevice {
    WasteManagerDto create(WasteManagerDto wasteManagerDto)throws Exception;
    WasteManagerDto update(WasteManagerDto wasteManagerDto,Long id)throws Exception;
    WasteManagerDto findById(long wasteManagerId) throws NotFoundException;

}

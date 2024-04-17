package com.testproject.wastemanagerservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.testproject.wastemanagerservice.dto.WasteManagerDto;
import com.testproject.wastemanagerservice.model.entity.WasteManagerEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IWasteMapper {

  IWasteMapper INSTANCE = Mappers.getMapper(IWasteMapper.class);

  @Mapping(target = "isEnabled", expression = "java(getBoolean(entity.getIsEnabled()))")
  @Mapping(target = "wasteManagerAddressManagerDto", source = "wasteManagerAddressEntity")
  @Mapping(target = "listOfWasteCenterAuthorizationDto", source = "listOfWasteCenterAuthorizationEntity")
  WasteManagerDto toDto(WasteManagerEntity entity);

  @Mapping(target = "isEnabled", expression = "java(getInt(wasteManagerDto.getIsEnabled()))")
  @Mapping(target = "wasteManagerAddressEntity", source = "wasteManagerAddressManagerDto")
  @Mapping(target = "listOfWasteCenterAuthorizationEntity", source = "listOfWasteCenterAuthorizationDto")
  WasteManagerEntity toEntity(WasteManagerDto wasteManagerDto);

  default boolean getBoolean(Integer value) {
    return value == 1;
  }

  default int getInt(boolean value) {
    return value ? 1 : 0;
  }
}

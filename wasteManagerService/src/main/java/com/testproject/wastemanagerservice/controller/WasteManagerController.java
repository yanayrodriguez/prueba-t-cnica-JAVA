package com.testproject.wastemanagerservice.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.testproject.wastemanagerservice.dto.WasteManagerDto;
import com.testproject.wastemanagerservice.service.IWasteManagerSevice;

@Controller
@RequestMapping(path = "/wasteManager")
public class WasteManagerController {
    @Autowired
    IWasteManagerSevice iwasteManagerSevice;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping(path = "/create")
    public ResponseEntity create(@RequestBody WasteManagerDto wasteManagerDto, BindingResult bindingResult)
            throws Exception {
        try {
            if (!bindingResult.hasErrors()) {
                return new ResponseEntity(iwasteManagerSevice.create(wasteManagerDto), HttpStatus.CREATED);
            } else {
                return new ResponseEntity("Internal Server Error: Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PatchMapping(path = "/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody WasteManagerDto wasteManagerDto,
            BindingResult bindingResult) throws Exception {
        try {
            if (!bindingResult.hasErrors()) {
                return new ResponseEntity(iwasteManagerSevice.update(wasteManagerDto, id), HttpStatus.OK);
            } else {
                return new ResponseEntity("Internal Server Error: Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping(path = "/findById")
    public ResponseEntity findById(@RequestParam("wasteManagerId") Long wasteManagerId) throws NotFoundException {
        try {
            return new ResponseEntity(iwasteManagerSevice.findById(wasteManagerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
package com.msvc.hotel.hotel.controllers;

import com.msvc.hotel.hotel.entity.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping()
    public ResponseEntity<List<String>> listarStaffs(){
        List<String> staffs = Arrays.asList("Camilo","Pipe","Luis","Nicolas");
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
}

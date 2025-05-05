package com.centime.dbservice.controller;

import com.centime.dbservice.annotation.LogMethodParam;
import com.centime.dbservice.dtos.LegendResponseDTO;
import com.centime.dbservice.entity.Legend;
import com.centime.dbservice.service.LegendService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/legend")
public class LegendController {

    private final LegendService service;

    public LegendController(LegendService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @LogMethodParam
    public Legend getById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new EntityNotFoundException("Legend not found with id " + id));
    }

    @GetMapping
    public List<LegendResponseDTO> getById() {
        return service.findAll();
    }
}

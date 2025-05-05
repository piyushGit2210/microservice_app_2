package com.centime.dbservice.dtos;

import com.centime.dbservice.repository.LegendRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LegendResponseDTO {
    private String name;
    private String color;
    private List<LegendResponseDTO> subClasses = new ArrayList<>();
}

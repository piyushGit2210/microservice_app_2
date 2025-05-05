package com.centime.dbservice.service;

import com.centime.dbservice.annotation.LogMethodParam;
import com.centime.dbservice.dtos.LegendResponseDTO;
import com.centime.dbservice.entity.Legend;
import com.centime.dbservice.repository.LegendRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LegendService {

    private final LegendRepository repository;

    public LegendService(LegendRepository repository) {
        this.repository = repository;
    }

    public Optional<Legend> findById(Long id) {
        return repository.findById(id);
    }

    public List<LegendResponseDTO> findAll() {
        List<Legend> legends = repository.findAll();
        // Group by parentId
        Map<Long, List<Legend>> groupedByParent = legends.stream()
                .collect(Collectors.groupingBy(Legend::getParentId));

        // Recursive builder
        return buildTree(groupedByParent, 0L);
    }

    @LogMethodParam
    private List<LegendResponseDTO> buildTree(Map<Long, List<Legend>> groupedByParent, Long parentId) {
        List<Legend> current = groupedByParent.getOrDefault(parentId, new ArrayList<>());
        List<LegendResponseDTO> result = new ArrayList<>();

        for (Legend c : current) {
            LegendResponseDTO dto = new LegendResponseDTO();
            dto.setName(c.getName());
            dto.setColor(c.getColor());
            dto.setSubClasses(buildTree(groupedByParent, c.getId()));
            result.add(dto);
        }
        return result;
    }
}

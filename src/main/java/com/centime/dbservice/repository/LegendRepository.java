package com.centime.dbservice.repository;

import com.centime.dbservice.entity.Legend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegendRepository extends JpaRepository<Legend, Long> {


}

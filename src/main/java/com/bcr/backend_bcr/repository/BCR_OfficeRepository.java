package com.bcr.backend_bcr.repository;

import com.bcr.backend_bcr.model.BCR_Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BCR_OfficeRepository extends JpaRepository<BCR_Office, Integer> {
//    List<BCR_Office> findBCR_OfficeByNumeRegex(String regex);
//    List<BCR_Office> findBCR_OfficeByOrasRegex(String regex);
}

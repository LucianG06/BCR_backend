package com.bcr.backend_bcr.repository;

import com.bcr.backend_bcr.model.BCR_Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BCR_OfficeRepository extends JpaRepository<BCR_Office, Integer> {
    @Query("SELECT p FROM BCR_Office p WHERE CONCAT(p.nume, p.strada, p.oras) LIKE %?1%")
    List<BCR_Office> findBCR_OfficeByRegex(String regex);

}

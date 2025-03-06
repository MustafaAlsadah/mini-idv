package com.miniidv.miniidv.repository;

import com.miniidv.miniidv.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}

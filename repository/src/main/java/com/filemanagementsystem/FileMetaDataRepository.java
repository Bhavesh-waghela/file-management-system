package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetadata, Long> {
}

package com.filemanagementsystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "FileMetadata")
public class FileMetadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for ID
    @Column(name = "id")
    private Long id;

    @Column(name = "path")  // Enforce unique path
    private String path;

    @Column(name = "filename")
    private String filename;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size")
    private Long size;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    @Column(name = "lastScannedDate")
    private LocalDate lastScannedDate;

    public FileMetadata(String path, String filename, String extension, Long size, LocalDate createdDate, LocalDate lastScannedDate) {
        this.path = path;
        this.filename = filename;
        this.extension = extension;
        this.size = size;
        this.createdDate = createdDate;
        this.lastScannedDate = lastScannedDate;
    }
}

package com.filemanagementsystem.domain;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "FILEMETADATA")
@AllArgsConstructor
public class FileMetadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "path")
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

    public FileMetadata(File file) {
        long lastModifiedMillis = file.lastModified();
        this.path = file.getAbsolutePath();
        this.filename = file.getName();
        this.extension = FilenameUtils.getExtension(path);
        this.size = file.length();
        this.createdDate = LocalDate.now();
        this.lastScannedDate = Instant.ofEpochMilli(lastModifiedMillis).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

package com.filemanagementsystem.dtos;


import java.io.Serializable;
import java.time.LocalDate;

public class FileMetaDataDto implements Serializable {
    private String path;
    private String filename;
    private String extension;
    private Long size;
    private LocalDate createdDate;
    private LocalDate lastScannedDate;
}

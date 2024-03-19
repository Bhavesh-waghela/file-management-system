package com.filemanagementsystem.controller;

import com.filemanagementsystem.FileMetaDataService;
import com.filemanagementsystem.domain.FileMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class FileMetaDataController {
    private final FileMetaDataService fileMetaDataService;

    @GetMapping("/files")
    public ResponseEntity<List<FileMetadata>> getAllFiles() throws IOException {
        log.info("FileMetaDataController::getAllFiles");
        return ResponseEntity.ok(fileMetaDataService.getAllFileMetadata());
    }
}

package com.filemanagementsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.filemanagementsystem.dtos.FileMetaDataDto;
import com.filemanagementsystem.FileMetaDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class FileMetaDataController {
    private final FileMetaDataService fileMetaDataService;
    private ObjectMapper mapper;

    @GetMapping("/files")
    public ResponseEntity<List<FileMetaDataDto>> getAllFiles() throws IOException {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        log.info("FileMetaDataController::getAllFiles");

        return ResponseEntity.ok(fileMetaDataService.getAllFileMetadata().stream()
                .map(o -> mapper.convertValue(o, FileMetaDataDto.class))
                .collect(Collectors.toList()));
    }
}

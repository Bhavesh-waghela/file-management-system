package com.filemanagementsystem.controller;

import com.filemanagementsystem.FileMetaDataService;
import com.filemanagementsystem.domain.FileMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class FileMetaDataController {
    private final FileMetaDataService fileMetaDataService;

    @Value("${file.upload.path}")
    private String dataFolder;

    @GetMapping("/files")
    public ResponseEntity<List<FileMetadata>> getAllFiles() throws IOException {
        log.info("FileMetaDataController::getAllFiles");
        return ResponseEntity.ok(fileMetaDataService.getAllFileMetadata());
    }

    @GetMapping("/folders")
    public ResponseEntity<List<String>> getListOfFolders() {
        return ResponseEntity.ok(fileMetaDataService.getListOfFolders(dataFolder));
    }

    @GetMapping("/filesizes")
    public ResponseEntity<List<Map<String, Object>>> getFileSizesByFilter(@RequestParam(value = "filetype", required = false)
                                                                 String filetype) throws IOException {
        return ResponseEntity.ok(fileMetaDataService.getFileSizesByFilter(dataFolder, filetype));
    }

    @DeleteMapping("/files")
    public ResponseEntity deleteFile() throws IOException {
        fileMetaDataService.deleteFile();
        return ResponseEntity.ok("All files deleted successfully!");
    }
}

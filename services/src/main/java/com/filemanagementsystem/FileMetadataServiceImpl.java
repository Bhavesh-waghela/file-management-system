package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FileMetadataServiceImpl implements FileMetaDataService {
    private FileMetaDataRepository fileMetaDataRepository;

    @Override
    public List<FileMetadata> getAllFileMetadata() throws IOException {
        List<FileMetadata> response = fileMetaDataRepository.findAll();
        log.info("FileMetaDataService::getAllFileMetadata response {}", response);
        return response;
    }
}

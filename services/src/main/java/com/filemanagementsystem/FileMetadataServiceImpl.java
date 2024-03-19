package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileMetadataServiceImpl implements FileMetaDataService {

    @Override
    public List<FileMetadata> getAllFileMetadata() throws IOException {
        List<FileMetadata> response = new ArrayList<>();
        log.info("FileMetaDataService::getAllFileMetadata response {}", response);
        return response;
    }
}

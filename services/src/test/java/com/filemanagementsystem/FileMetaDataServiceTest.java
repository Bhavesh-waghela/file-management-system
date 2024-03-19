package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileMetaDataServiceTest {

    private FileMetaDataService fileMetaDataService;

    @Test
    void getAllFiles_shouldReturnNull() throws IOException {
        fileMetaDataService = new FileMetadataServiceImpl();

        List<FileMetadata> fileMetadataList = fileMetaDataService.getAllFileMetadata();

        assertEquals(0, fileMetadataList.size());
    }
}
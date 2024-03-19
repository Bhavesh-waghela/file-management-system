package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileMetaDataServiceTest {
    private FileMetaDataService fileMetaDataService;
    @MockBean
    private FileMetaDataRepository fileMetaDataRepository;

    @BeforeEach
    void setup() {
        this.fileMetaDataService = new FileMetadataServiceImpl(fileMetaDataRepository);
    }

    @Test
    void getAllFiles_shouldReturnNull() throws IOException {
        List<FileMetadata> fileMetadataList = fileMetaDataService.getAllFileMetadata();

        assertEquals(0, fileMetadataList.size());
    }
}
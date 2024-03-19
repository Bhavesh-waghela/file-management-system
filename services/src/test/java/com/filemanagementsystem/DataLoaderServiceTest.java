package com.filemanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataLoaderServiceTest {

    private DataLoaderService dataLoaderService;

    @Mock
    private FileMetadataServiceImpl fileMetadataService;

    private static String PATH = "/file-management-system/services/src/test/resources/data";

    @BeforeEach
    void setup() {
        this.dataLoaderService = new DataLoaderServiceImpl(fileMetadataService);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadDataOnStartup_OK() throws IOException {
        int sizeBefore = fileMetadataService.getAllFileMetadata().size();
        assertEquals(1, sizeBefore);

        dataLoaderService.loadDataOnStartup(PATH);

        int sizeAfter = fileMetadataService.getAllFileMetadata().size();
        assertEquals(1, sizeAfter);
    }
}
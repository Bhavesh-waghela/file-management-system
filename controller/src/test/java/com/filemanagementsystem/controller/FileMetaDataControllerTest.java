package com.filemanagementsystem.controller;

import com.filemanagementsystem.FileMetaDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@ExtendWith(MockitoExtension.class)
public class FileMetaDataControllerTest {
    private MockMvc mockMvc;
    @Mock
    private FileMetaDataService fileMetaDataService;
    @InjectMocks
    private FileMetaDataController fileMetaDataController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(fileMetaDataController)
                .build();
    }

    @Test
    void getAllFiles_OK() throws Exception {
        when(fileMetaDataService.getAllFileMetadata())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/files"))
                .andExpect(status().isOk());

        verify(fileMetaDataService).getAllFileMetadata();
    }
}
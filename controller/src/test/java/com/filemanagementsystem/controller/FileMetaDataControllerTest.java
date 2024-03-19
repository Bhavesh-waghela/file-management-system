package com.filemanagementsystem.controller;

import com.filemanagementsystem.FileMetaDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
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
        mockMvc.perform(get("/api/files"))
                .andExpect(status().isOk());

    }
    @Test
    void getListOfFolders_OK() throws Exception {
      mockMvc.perform(get("/api/folders"))
                .andExpect(status().isOk());
    }

    @Test
    void getFileSizesByFilter_OK() throws Exception {
        mockMvc.perform(get("/api/filesizes"))
                .andExpect(status().isOk());
    }

    @Test
    void purgeAllFiles_OK() throws Exception {
        mockMvc.perform(delete("/api/files"))
                .andExpect(status().isOk());
    }
}
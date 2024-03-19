package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class FileMetaDataServiceTest {
    private FileMetaDataService fileMetaDataService;
    @Mock
    private FileMetaDataRepository fileMetaDataRepository;

    private static String PATH = "/file-management-system/services/src/test/resources/data";

    @BeforeEach
    void setup() {
        this.fileMetaDataService = new FileMetadataServiceImpl(fileMetaDataRepository);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllFiles_shouldReturnNull() throws IOException {
        List<FileMetadata> fileMetadataList = fileMetaDataService.getAllFileMetadata();
        assertEquals(0, fileMetadataList.size());
    }

//    @Test
//    void saveAllFilesMetaData_shouldSaveRecords() throws IOException {
//        List<FileMetadata> fileMetadataList = createSampleExistingData();
//
//        fileMetaDataService.saveAllFilesMetaData(fileMetadataList);
//
//        assertEquals(fileMetadataList.size(), fileMetaDataService.getAllFileMetadata().size());
//    }

    @Test
    void getListOfFolders_shouldRetrunFoldersList() {
        List<String> folders = fileMetaDataService.getListOfFolders(PATH);

        assertNotNull(folders);
        assertEquals(1, folders.size());
    }

    @Test
    void getListOfFolders_shouldRetrunEmptyFoldersList() {
        List<String> folders = fileMetaDataService.getListOfFolders(PATH);

        assertEquals(0, folders.size());
    }

    @Test
    void getFileSizesByFilter_shouldReturnFilesSizes() throws IOException {
        List<Map<String, Object>> result = fileMetaDataService.getFileSizesByFilter(PATH+"/inner", "txt");

        assertNotNull(result);
        assertEquals(0L, result.get(0).get("size"));
        assertEquals("inner", result.get(0).get("name"));
    }

    @Test
    void getFileSizesByFilter_shouldReturnNoFiles() throws IOException {
        List<Map<String, Object>> result = fileMetaDataService.getFileSizesByFilter(PATH+"/outer", "txt");

        assertEquals(0, result.size());
    }

//    @Test
//    void deleteFile_shouldDeleteFiles() throws IOException {
//        List<FileMetadata> fileMetadataList = createSampleExistingData();
//
//        fileMetaDataService.saveAllFilesMetaData(fileMetadataList);
//        int sizeBefore = fileMetaDataService.getAllFileMetadata().size();
//
//        assertEquals(1, sizeBefore);
//
//        fileMetaDataService.deleteFile();
//        int sizeAfter = fileMetaDataService.getAllFileMetadata().size();
//
//        assertEquals(0, sizeAfter);
//    }

    private List<FileMetadata> createSampleExistingData() {
        List<FileMetadata> existingData = new ArrayList<>();
        existingData.add(new FileMetadata(1L, "/path/to/file1.txt", "file1.txt",
                "txt", 1024L, LocalDate.now(), LocalDate.now()));
        return existingData;
    }
}
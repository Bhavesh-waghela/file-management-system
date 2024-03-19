package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileMetaDataService {
    List<FileMetadata> getAllFileMetadata() throws IOException;

    void saveAllFilesMetaData(List<FileMetadata> fileMetadata);

    List<String> getListOfFolders(String path);

    List<Map<String, Object>> getFileSizesByFilter(String path, String filetype) throws IOException;

    void deleteFile();
}

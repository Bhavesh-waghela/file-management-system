package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;

import java.io.IOException;
import java.util.List;

public interface FileMetaDataService {
    List<FileMetadata> getAllFileMetadata() throws IOException;
}

package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataLoaderServiceImpl implements DataLoaderService {
    private FileMetaDataService fileMetaDataService;

    public void loadDataOnStartup(String path) {
        List<FileMetadata> fileMetadataList = new ArrayList<>();
        scanDirectory(new File(path), fileMetadataList);
        fileMetaDataService.saveAllFilesMetaData(fileMetadataList);
    }

    protected void scanDirectory(File directory, List<FileMetadata> fileMetadataList) {
        File[] files = directory.listFiles();
        if(files!=null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileMetadataList.add(new FileMetadata(file));
                } else if (file.isDirectory()) {
                    scanDirectory(file, fileMetadataList);
                }
            }
        }
    }
}

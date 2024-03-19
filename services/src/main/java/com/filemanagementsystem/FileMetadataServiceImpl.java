package com.filemanagementsystem;

import com.filemanagementsystem.domain.FileMetadata;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class FileMetadataServiceImpl implements FileMetaDataService {
    private FileMetaDataRepository fileMetaDataRepository;

    @Override
    public List<FileMetadata> getAllFileMetadata() throws IOException {
        List<FileMetadata> response = fileMetaDataRepository.findAll();
        log.info("FileMetaDataService::getAllFileMetadata body {}", response);
        return response;
    }

    @Override
    public void saveAllFilesMetaData(List<FileMetadata> fileMetadata) {
        log.info("FileMetaDataService::saveAllFilesMetaData body {}", fileMetadata);
        fileMetaDataRepository.saveAll(fileMetadata);
    }

    @Override
    public List<String> getListOfFolders(String path) {
        log.info("FileMetaDataService::getListOfFolders");

        List<String> folderNames = new ArrayList<>();
        File dataFolder = new File(path);

        if (dataFolder.exists() && dataFolder.isDirectory()) {
            listFolders(dataFolder, folderNames);
            Collections.sort(folderNames);
        } else {
            log.error("Data folder not found: " + path);
        }

        return folderNames;
    }

    @Override
    public List<Map<String, Object>> getFileSizesByFilter(String path, String filter) throws IOException {
        log.info("FileMetaDataService::getFileSizesByFilter path {} filter {}", path, filter);

        List<Map<String, Object>> folderSizes = new ArrayList<>();
        Path dataPath = Paths.get(path);

        if (Files.exists(dataPath)) {
            Map<String, Long> sizeMap = new HashMap<>();
            calculateFolderSizes(dataPath, sizeMap, filter);

            for (Map.Entry<String, Long> entry : sizeMap.entrySet()) {
                Map<String, Object> folderInfo = new HashMap<>();
                folderInfo.put("name", entry.getKey());
                folderInfo.put("size", entry.getValue());
                folderSizes.add(folderInfo);
            }
            folderSizes.sort((o1, o2) -> Long.compare((Long) o2.get("size"), (Long) o1.get("size")));
        } else {
            log.error("Data folder not found: " + path);
        }
        log.info("FileMetaDataService::getFileSizesByFilter response {}", folderSizes);

        return folderSizes;
    }

    @Override
    public void deleteFile() {
        log.info("FileMetaDataService::deleteFile");

        fileMetaDataRepository.deleteAll();
    }

    private void calculateFolderSizes(Path folderPath, Map<String, Long> sizeMap, String filter) throws IOException {
        for (File file : folderPath.toFile().listFiles()) {
            if (file.isDirectory()) {
                calculateFolderSizes(file.toPath(), sizeMap, filter);
            } else if (filter == null || file.getName().endsWith(filter)) {
                long fileSize = Files.size(file.toPath());
                String folderName = folderPath.getFileName().toString();
                sizeMap.put(folderName, sizeMap.getOrDefault(folderName, 0L) + fileSize);
            }
        }
    }

    private void listFolders(File folder, List<String> folderNames) {
        File[] subfolders = folder.listFiles(File::isDirectory);
        if (subfolders != null) {
            for (File subfolder : subfolders) {
                folderNames.add(subfolder.getName());
                listFolders(subfolder, folderNames);
            }
        }
    }
}

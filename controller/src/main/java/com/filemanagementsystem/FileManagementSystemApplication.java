package com.filemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagementSystemApplication implements ApplicationRunner {

	@Value("${file.upload.path}")
	private String dataFolder;
	@Autowired
	DataLoaderService loaderService;

	public static void main(String[] args) {
		SpringApplication.run(FileManagementSystemApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		loaderService.loadDataOnStartup(dataFolder);
	}
}

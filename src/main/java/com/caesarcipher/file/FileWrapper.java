package com.caesarcipher.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class FileWrapper {

	public File createFile(String pathname) {
		return new File(pathname);
	}

	public FileSystemResource createSystemFile(String path) {
		return new FileSystemResource(path);
	}

	public FileWriter createFileWriter(File file) throws IOException {
		return new FileWriter(file);
	}

}

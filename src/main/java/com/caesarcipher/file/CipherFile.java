package com.caesarcipher.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.caesarcipher.constants.CaesarCipherConstants;
import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.exception.FileException;

@Component
public class CipherFile {

	FileWrapper fileWrapper;

	@Autowired
	public CipherFile(FileWrapper fileWrapper) {
		this.fileWrapper = fileWrapper;
	}

	/**
	 * @param json
	 * @return
	 * @throws FileException
	 */
	public FileSystemResource createJsonFile(JSONObject json) throws FileException {
		File file = fileWrapper.createFile(CaesarCipherConstants.FILE_NAME);
		FileWriter fileWriter = write(file, json);
		close(fileWriter);
		return fileWrapper.createSystemFile(file.getPath());
	}

	/**
	 * @param json
	 * @return
	 * @throws FileException
	 */
	private FileWriter write(File file, JSONObject json) throws FileException {
		try {
			FileWriter fileWriter = fileWrapper.createFileWriter(file);
			fileWriter.write(json.toString());
			return fileWriter;
		}
		catch (IOException e) {
			throw new FileException(CaesarCipherException.FILE_WRITE_ERROR);
		}
	}

	/**
	 * @throws FileException
	 */
	private void close(FileWriter fileWriter) throws FileException {
		try {
			fileWriter.flush();
			fileWriter.close();
		}
		catch (IOException e) {
			throw new FileException(CaesarCipherException.FILE_CLOSE_ERROR);
		}
	}

}

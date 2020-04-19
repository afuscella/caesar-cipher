package com.caesarcipher.converter;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caesarcipher.constants.CaesarCipherConstants;

public class CipherToDecipher {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public String decipher(int numberShift, String cipher) {
		char[] cipherArr = cipher.toCharArray();
		StringBuilder decipher = new StringBuilder();

		logger.info("Decoding token: {}", cipher);

		for (char c : cipherArr) {
			for (int i = 0; i < CaesarCipherConstants.ALPHABET.length; i++) {
				if (Objects.equals(c, CaesarCipherConstants.ALPHABET[i])) {
					decipher.append(convertCharToCaesarCipher(numberShift + i));
					break;
				}

				if (Objects.equals(CaesarCipherConstants.ALPHABET_LENGTH, i)) {
					decipher.append(c);
				}
			}
		}
		return decipher.toString();
	}

	private char convertCharToCaesarCipher(int shift) {
		int position;

		if (shift > CaesarCipherConstants.ALPHABET_LENGTH) {
			position = shift - CaesarCipherConstants.ALPHABET.length;
		}
		else {
			position = shift;
		}

		if (position > CaesarCipherConstants.ALPHABET_LENGTH) {
			return convertCharToCaesarCipher(position);
		}
		else {
			return CaesarCipherConstants.ALPHABET[position];
		}
	}
}

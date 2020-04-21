package com.caesarcipher.converter;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.caesarcipher.constants.CaesarCipherConstants;

@Component
public class CaesarCipher {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public String decode(int numberShift, String cipher) {
		char[] cipherArr = cipher.toCharArray();
		char character = 0;
		StringBuilder decoded = new StringBuilder();

		logger.info("decoding token: {}", cipher);

		for (char c : cipherArr) {
			for (int i = 0; i < CaesarCipherConstants.ALPHABET.length; i++) {
				if (Objects.equals(c, CaesarCipherConstants.ALPHABET[i])) {
					character = decodeCharToCaesarCipher(numberShift + i);
					break;
				}
				character = c;
			}
			decoded.append(character);
		}
		return decoded.toString();
	}

	private char decodeCharToCaesarCipher(int shift) {
		int position = shift;

		if (shift > CaesarCipherConstants.ALPHABET_LENGTH) {
			position = shift - CaesarCipherConstants.ALPHABET.length;
		}

		if (position > CaesarCipherConstants.ALPHABET_LENGTH) {
			return decodeCharToCaesarCipher(position);
		}
		else {
			return CaesarCipherConstants.ALPHABET[position];
		}
	}
}

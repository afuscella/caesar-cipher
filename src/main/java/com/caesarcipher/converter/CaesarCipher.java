package com.caesarcipher.converter;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.caesarcipher.constants.CaesarCipherConstants;

@Component
public class CaesarCipher {

	/**
	 * Decode cipher string
	 * @param numberShift
	 * @param cipher
	 * @return
	 */
	public String decode(int numberShift, String cipher) {
		StringBuilder decoded = new StringBuilder();
		char character = 0;

		for (char c : cipher.toCharArray()) {
			for (int i = 0; i <= CaesarCipherConstants.ALPHABET_ARRAY_LENGTH; i++) {
				if (Objects.equals(c, CaesarCipherConstants.ALPHABET[i])) {
					character = decodeCharToCaesarCipher(numberShift, i);
					break;
				}
				character = c;
			}
			decoded.append(character);
		}
		return decoded.toString();
	}

	/**
	 * Encode cipher string
	 * @param numberShift
	 * @param cipher
	 * @return
	 */
	public String encode(int numberShift, String cipher) {
		StringBuilder encoded = new StringBuilder();
		char character = 0;

		for (char c : cipher.toCharArray()) {
			for (int i = CaesarCipherConstants.ALPHABET_ARRAY_LENGTH; i >= 0; i--) {
				if (Objects.equals(c, CaesarCipherConstants.ALPHABET[i])) {
					character = encodeCharToCaesarCipher(numberShift, i);
					break;
				}
				character = c;
			}
			encoded.append(character);
		}
		return encoded.toString();
	}

	/**
	 * decode char into caesar cipher
	 * @param shift
	 * @param currentPosition
	 * @return
	 */
	private char decodeCharToCaesarCipher(int shift, int currentPosition) {
		int position;

		if (shift > CaesarCipherConstants.ALPHABET_LENGTH || shift > currentPosition) {
			position = shift - CaesarCipherConstants.ALPHABET_LENGTH;
			return decodeCharToCaesarCipher(position, currentPosition);
		}
		position = Math.abs(currentPosition - shift);
		return CaesarCipherConstants.ALPHABET[position];
	}

	/**
	 * encode char into caesar cipher
	 * @param shift
	 * @param currentPosition
	 * @return
	 */
	private char encodeCharToCaesarCipher(int shift, int currentPosition) {
		int position;

		if (shift > CaesarCipherConstants.ALPHABET_LENGTH) {
			position = shift - CaesarCipherConstants.ALPHABET_LENGTH;
			return encodeCharToCaesarCipher(position, currentPosition);
		}
		position = Math.abs(currentPosition + shift);

		if (position >= CaesarCipherConstants.ALPHABET_LENGTH) {
			position -= CaesarCipherConstants.ALPHABET_LENGTH;
		}
		return CaesarCipherConstants.ALPHABET[position];
	}
}

package br.com.gomide.data_structures.hash_map;

import java.util.Base64;

public class URLShortener implements IURLShortener {

	@Override
	public String encode(String url) throws RuntimeException {
		return getPrefix() + encodeBase64(url);
	}

	@Override
	public String decode(String encodedUrl) throws RuntimeException {
		String code = getCode(encodedUrl);
		return decodeBase64(code);
	}

	@Override
	public String getPrefix() {
		return "https://cut.com.br/";
	}
	
	private String getCode(String url) {
		return url.substring(getPrefix().length());
	}
	
	private String decodeBase64(String seed) {
		byte[] decodedBytes = Base64.getDecoder().decode(seed);
		return new String(decodedBytes);
	}
	
	private String encodeBase64(String seed) {
		return Base64.getEncoder().encodeToString(seed.getBytes());
	}
	
}

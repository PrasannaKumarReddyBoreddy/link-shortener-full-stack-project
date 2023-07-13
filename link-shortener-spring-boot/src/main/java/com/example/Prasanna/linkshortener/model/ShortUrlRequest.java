package com.example.Prasanna.linkshortener.model;

public class ShortUrlRequest {

	private String originalUrl;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public ShortUrlRequest(String originalUrl) {
		super();
		this.originalUrl = originalUrl;
	}
	public ShortUrlRequest() {}
	
}

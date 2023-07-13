package com.example.Prasanna.linkshortener.model;

public class ShortUrlResponse {

	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public ShortUrlResponse(String shortUrl) {
		super();
		this.shortUrl = shortUrl;
	}
	
	public ShortUrlResponse() {
	}
}

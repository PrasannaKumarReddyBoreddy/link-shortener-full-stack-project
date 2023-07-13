package com.example.Prasanna.linkshortener.model;

import jakarta.persistence.*;

@Entity
@Table(name = "short_urls")
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "expiry_time")
    private long expiryTime;

	public ShortUrl(Long id, String originalUrl, String shortUrl, long expiryTime) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.expiryTime = expiryTime;
	}

	public ShortUrl() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	
}

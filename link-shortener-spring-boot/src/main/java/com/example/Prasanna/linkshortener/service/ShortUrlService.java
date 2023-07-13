package com.example.Prasanna.linkshortener.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prasanna.linkshortener.model.ShortUrl;
import com.example.Prasanna.linkshortener.repository.ShortUrlRepository;

@Service
public class ShortUrlService {

    private static final long EXPIRY_DURATION_MINUTES = 5;

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrl createShortUrl(String originalUrl) {
        ShortUrl existingShortUrl = shortUrlRepository.findByOriginalUrl(originalUrl);
        if (existingShortUrl != null) {
            return existingShortUrl;
        }

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortUrl(generateShortUrl());
        shortUrl.setExpiryTime(getExpiryTime());

        return shortUrlRepository.save(shortUrl);
    }

    public ShortUrl findByShortUrl(String shortUrl) {
        ShortUrl url = shortUrlRepository.findByShortUrl(shortUrl);
        if (url == null) {
            throw new IllegalArgumentException("Short URL does not exist.");
        }
        if (isExpired(url)) {
            throw new IllegalArgumentException("Short URL has expired.");
        }
        return url;
    }

    private String generateShortUrl() {
        return "http://localhost:7070"+UUID.randomUUID().toString().substring(0, 7);
    }

    private long getExpiryTime() {
        LocalDateTime expiryDateTime = LocalDateTime.now().plusMinutes(EXPIRY_DURATION_MINUTES);
        return expiryDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    private boolean isExpired(ShortUrl url) {
        return System.currentTimeMillis() > url.getExpiryTime() * 1000;
    }
    
}

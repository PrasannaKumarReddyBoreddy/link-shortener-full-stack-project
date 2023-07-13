package com.example.Prasanna.linkshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Prasanna.linkshortener.model.ShortUrl;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
	ShortUrl findByShortUrl(String shortUrl);
	ShortUrl findByOriginalUrl(String originalUrl);

}

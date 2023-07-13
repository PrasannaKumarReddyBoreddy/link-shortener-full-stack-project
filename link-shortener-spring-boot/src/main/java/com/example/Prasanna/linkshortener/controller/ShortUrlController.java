package com.example.Prasanna.linkshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Prasanna.linkshortener.model.*;
import com.example.Prasanna.linkshortener.service.ShortUrlService;

@RestController
@CrossOrigin(origins= "*", maxAge = 3600)
public class ShortUrlController {
	  private final ShortUrlService shortUrlService;

	    @Autowired
	    public ShortUrlController(ShortUrlService shortUrlService) {
	        this.shortUrlService = shortUrlService;
	    }

	    @PostMapping("/shorten")
	    public ResponseEntity<?> shortenUrl(@RequestBody ShortUrlRequest request) {
	        try {
	            System.out.println("OriginalURL******* :: "+ request.getOriginalUrl());
	            ShortUrl shortUrl = shortUrlService.createShortUrl(request.getOriginalUrl());
	            System.out.println("ShortURL ******* :: "+ shortUrl);
	            return ResponseEntity.ok(new ShortUrlResponse(shortUrl.getShortUrl()));
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
	        }
	    }

	    @GetMapping("/{shortUrl}")
	    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl) {
	        try {
	            ShortUrl url = shortUrlService.findByShortUrl(shortUrl);
	            return ResponseEntity.status(HttpStatus.FOUND).header("Location", url.getOriginalUrl()).build();
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
	        }
	    }

}

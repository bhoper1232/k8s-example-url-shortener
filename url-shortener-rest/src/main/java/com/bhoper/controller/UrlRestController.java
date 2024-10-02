package com.bhoper.controller;

import com.bhoper.service.UrlModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlRestController {

    private final UrlModelService urlModelService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("originalUrl");
        return this.urlModelService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originUrl = this.urlModelService.getOriginalUrl(shortUrl);
        return new RedirectView(originUrl);
    }

    @GetMapping("/originalUrl")
    public String getOriginalUrl(@RequestParam String shortUrl) {
        return this.urlModelService.getOriginalUrl(shortUrl);
    }
}

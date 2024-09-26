package com.bhoper.client.url;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@FeignClient(name = "url-shortener", url = "http://url-shortener-rest")
public interface UrlClient {

    @PostMapping("/api/url/shorten")
    String shortenUrl(@RequestBody Map<String, String> request);

    @GetMapping("/api/url/{shortUrl}")
    RedirectView redirectToOriginalUrl(@PathVariable String shortUrl);

}

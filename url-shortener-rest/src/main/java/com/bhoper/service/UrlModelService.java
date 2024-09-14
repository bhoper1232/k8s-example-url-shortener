package com.bhoper.service;

import com.bhoper.model.UrlModel;
import com.bhoper.repository.UrlModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UrlModelService {

    private final UrlModelRepository urlModelRepository;

    public String shortenUrl(String longUrl) {
        UrlModel urlModel = this.urlModelRepository.findByOriginalUrl(longUrl);
        if (urlModel != null) {
            return urlModel.getShortUrl();
        }

        UrlModel model = new UrlModel();
        model.setOriginalUrl(longUrl);
        UrlModel savedUrl = this.urlModelRepository.save(model);

        String shortUrl = encodeUrl(savedUrl.getId());
        savedUrl.setShortUrl(shortUrl);
        this.urlModelRepository.save(savedUrl);

        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        UrlModel urlModel = this.urlModelRepository.findByShortUrl(shortUrl);
        if (urlModel != null) {
            return urlModel.getOriginalUrl();
        }
        throw new RuntimeException("Short URL not found");
    }

    private String encodeUrl(String id) {
        return Base64.getUrlEncoder().encodeToString(id.getBytes());
    }

}

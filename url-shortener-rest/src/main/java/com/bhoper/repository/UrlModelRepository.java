package com.bhoper.repository;

import com.bhoper.model.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlModelRepository extends MongoRepository<UrlModel, Long> {

    UrlModel findByShortUrl(String shortUrl);
    UrlModel findByOriginalUrl(String longUrl);
}

package com.bhoper.client.url;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrlModel {

    String id;
    String shortUrl;
    String originalUrl;

    public UrlModel(String shortUrl, String originalUrl) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

}
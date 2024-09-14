package com.bhoper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "url-metric")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlMetricModel {

    @Id
    private Date timestamp;
    private String shortUrl;
    private String userAgent;
    private String ipAddress;

}

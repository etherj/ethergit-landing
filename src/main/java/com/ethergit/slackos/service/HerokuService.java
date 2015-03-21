package com.ethergit.slackos.service;

import com.ethergit.slackos.model.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HerokuService {

    RestTemplate restTemplate;

    @Autowired
    public HerokuService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getLast10Releases() {

        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Accept", "application/json");
        headersMap.put("Authorization", "Bearer 5bfed83b-14d3-432d-a10d-78a645efa2ac");

        HttpHeaders headers = new HttpHeaders();
        headers.setAll(headersMap);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Release>> res =
                restTemplate.exchange("https://api.heroku.com/apps/ethergit-site/releases", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Release>>() {
                });

        StringBuffer buffer = new StringBuffer();

        int last = res.getBody().size() - 1;
        for (int i = 0; i < 10; ++i) {

            Release release = res.getBody().get(last - i);

            String releaseRaw =
                    String.format("%s | %s | %s | %s \n",
                            release.getCommit(), release.getName(),
                            release.getCreated_at(), release.getDescr());

            buffer.append(releaseRaw);
        }

        return buffer.toString();
    }

}

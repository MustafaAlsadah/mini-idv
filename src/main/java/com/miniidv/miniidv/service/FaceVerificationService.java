package com.miniidv.miniidv.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class FaceVerificationService {

    @Value("${face.api.url}")
    private String apiURL;

    @Value("${face.api.key}")
    private String apiKey;

    @Value("${face.api.secret}")
    private String apiSecret;

    @Value("${face.api.threshold}")
    private int confidenceThreshold;

    private final RestTemplate rest = new RestTemplate();

    public String compareFaces(String selfieUrl, String idCardUrl){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("api_key", apiKey);
        requestBody.add("api_secret", apiSecret);
        requestBody.add("image_url1", selfieUrl);
        requestBody.add("image_url2", idCardUrl);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = rest.exchange(apiURL, HttpMethod.POST, requestEntity, Map.class);
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("confidence")) {
                double confidence = (double) responseBody.get("confidence");
                return confidence >= confidenceThreshold ? "APPROVED" : "REJECTED";
            }
        }catch (Exception e){
            return "ERROR";
        }

        return "ERROR";
    }
}

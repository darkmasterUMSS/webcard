package com.example.demo.controller;

import com.example.demo.service.BuilderWebCardHtmlService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bruno Ramirez
 */
@RestController
public class GetWebCardController {

    private final BuilderWebCardHtmlService builderWebCardHtmlService;

    public GetWebCardController(BuilderWebCardHtmlService builderWebCardHtmlService) {
        this.builderWebCardHtmlService = builderWebCardHtmlService;
    }

    @GetMapping(value = "/preview", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getPreview(@RequestParam("hashedObject") String hashedObject) {
        try {
            String htmlBody = builderWebCardHtmlService.buildHtml(hashedObject);
            return ResponseEntity.ok(htmlBody);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in process build web card: " + e.getMessage());
        }
    }
}
